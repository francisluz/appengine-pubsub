package com.google.cloud.pubsub.client.demos.appengine;

/**
 * A class holds constants.
 */
public final class Constants {
    /**
     * A memcache key for storing query result for recent messages.
     */
    public static final String MESSAGE_CACHE_KEY = "messageCache";
    /**
     * A base package name.
     */
    public static final String BASE_PACKAGE =
            "com.google.cloud.pubsub.client.demos.appengine";
    /**
     * Google cloud storage object change notification watch channel identifier.
     */
    public static final String GCS_CHANNEL_ID =
            "3755d4a9-8738-4954-b6ca-a4af805733a3";
    /**
     * Google cloud storage object change notification resource identifier.
     */
    public static final String GCS_RESOURCE_ID =
            "0WkLIVUHCLnbVM7UcTNDlXQDkeY";

    /**
     * Prevents instantiation.
     */
    private Constants() {
    }
}
