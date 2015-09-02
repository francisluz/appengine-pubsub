package com.google.cloud.pubsub.client.demos.appengine.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by idalgo on 20/07/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {
    private String kind;
    private String id;
    private String selfLink;
    private String name;
    private String bucket;
    private String generation;
    private String metageneration;
    private String contentType;
    private String updated;
    private String size;
    private String md5Hash;
    private String mediaLink;
    private Owner owner;
    private String crc32c;
    private String etag;

    @Override
    public String toString() {
        return "{" +
                "\"kind\":\"" + kind + "\"" +
                ", \"id\":\"" + id + "\"" +
                ", \"selfLink\":\"" + selfLink + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"bucket\":\"" + bucket + "\"" +
                ", \"generation\":\"" + generation + "\"" +
                ", \"metageneration\":\"" + metageneration + "\"" +
                ", \"contentType\":\"" + contentType + "\"" +
                ", \"updated\":\"" + updated + "\"" +
                ", \"size\":\"" + size + "\"" +
                ", \"md5Hash\":\"" + md5Hash + "\"" +
                ", \"mediaLink\":\"" + mediaLink + "\"" +
                ", \"owner\": { " + owner + "\""  +
                "}" +
                ", \"crc32c\":\"" + crc32c + "\"" +
                ", \"etag\":\"" + etag + "\"" +
                "}";
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public void setMetageneration(String metageneration) {
        this.metageneration = metageneration;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMd5Hash(String md5Hash) {
        this.md5Hash = md5Hash;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setCrc32c(String crc32c) {
        this.crc32c = crc32c;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getName() {
        return name;
    }

    public String getBucket() {
        return bucket;
    }

    public String getGeneration() {
        return generation;
    }

    public String getMetageneration() {
        return metageneration;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUpdated() {
        return updated;
    }

    public String getSize() {
        return size;
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getCrc32c() {
        return crc32c;
    }

    public String getEtag() {
        return etag;
    }
}
