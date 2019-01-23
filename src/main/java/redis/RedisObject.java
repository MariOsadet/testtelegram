package redis;

import ai.grakn.redisq.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class RedisObject implements Document {

    @JsonProperty
    private  String fileId;

    @JsonProperty
    private  String id;


    private boolean processed;

    public RedisObject() {
    }

    public RedisObject(String fileId, String id) {
        this.fileId = fileId;
        this.id = id;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }


    @JsonIgnore
    public String getFileId() {
        return fileId;
    }

    @JsonIgnore
    public String getIdAsString() {
        return id;
    }

    @JsonIgnore
    public boolean isProcessed() {
        return processed;
    }
}
