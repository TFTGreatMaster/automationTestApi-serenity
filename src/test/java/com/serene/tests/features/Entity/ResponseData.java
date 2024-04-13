package com.serene.tests.features.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {
    @JsonProperty("content")
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
