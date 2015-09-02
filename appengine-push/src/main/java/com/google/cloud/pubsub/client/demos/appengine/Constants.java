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
            "b26ae6af-97e0-4223-9c86-385a9db5d07a";
    /**
     * Google cloud storage object change notification resource identifier.
     */
    public static final String GCS_RESOURCE_ID =
            "Q35ZJ11mZvmhZalimlxl1s7wNDw";

    /**
     * Prevents instantiation.
     */
    private Constants() {
    }
}
