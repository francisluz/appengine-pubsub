package com.google.cloud.pubsub.client.demos.appengine.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by idalgo on 20/07/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
    private String entity;
    private String entityId;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return  "\"entity\":\"" + entity + "\"" +
                ", \"entityId\":\"" + entityId + "\"";
    }
}
