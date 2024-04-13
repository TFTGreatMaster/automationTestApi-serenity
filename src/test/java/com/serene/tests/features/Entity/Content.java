package com.serene.tests.features.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    @JsonProperty("list")
    private String[] list;

    @JsonProperty("totalRecord")
    private int totalRecord;

    @JsonProperty("currentPage")
    private int currentPage;

    @JsonProperty("warning")
    private String warning;

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}