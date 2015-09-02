/*
 * Copyright (c) 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.google.cloud.pubsub.client.demos.appengine.servlet;

import com.google.api.services.pubsub.Pubsub;
import com.google.api.services.pubsub.model.PublishRequest;
import com.google.api.services.pubsub.model.PubsubMessage;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.cloud.pubsub.client.demos.appengine.Constants;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.pubsub.client.demos.appengine.model.Notification;
import com.google.cloud.pubsub.client.demos.appengine.util.PubsubUtils;
import com.google.common.collect.ImmutableList;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Processes incoming messages and sends them to the client web app.
 */
public class ReceiveFileNotificationServlet extends HttpServlet {

    @Override
    @SuppressWarnings("unchecked")
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws IOException {
        // Validating unique subscription token before processing the message
        if( !Constants.GCS_CHANNEL_ID.equals(req.getHeader("X-Goog-Channel-ID"))
                && !Constants.GCS_RESOURCE_ID.equals(req.getHeader("X-Goog-Resource-ID"))){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().close();
            return;
        }
        // Validate if the notification is for a new file or update
        if(!req.getHeader("X-Goog-Resource-State").equals("exists")){
            // Acknowledge the message by returning a success code
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().close();
            return;
        }

        Pubsub client = PubsubUtils.getClient();
        ServletInputStream inputStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();

        Notification message = mapper.readValue(inputStream, Notification.class);
        // Store the message in the datastore
        Entity messageToStore = new Entity("PubsubMessage");
        messageToStore.setProperty("message",
                "ReceiveFileNotificationServlet " +  message.toString());
        messageToStore.setProperty("receipt-time", System.currentTimeMillis());
        DatastoreService datastore =
                DatastoreServiceFactory.getDatastoreService();
        datastore.put(messageToStore);

        // Invalidate the cache
        MemcacheService memcacheService =
                MemcacheServiceFactory.getMemcacheService();
        memcacheService.delete(Constants.MESSAGE_CACHE_KEY);

        // Send message
        String fullTopicName = String.format("projects/%s/topics/%s",
                PubsubUtils.getProjectId(),
                PubsubUtils.getAppTopicName());
        PubsubMessage pubsubMessage = new PubsubMessage();
        pubsubMessage.encodeData(mapper.writeValueAsString(message).getBytes("UTF-8"));
        PublishRequest publishRequest = new PublishRequest();
        publishRequest.setMessages(ImmutableList.of(pubsubMessage));

        client.projects().topics()
                .publish(fullTopicName, publishRequest)
                .execute();

        // Acknowledge the message by returning a success code
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().close();
    }
}
