package org.wd.doc.event.dto;

import java.util.List;
import java.util.Map;

public class Message {

    private String summary;

    private String description;

    private Map<String, String> headers;

    private List<Field> payload;

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(final Map<String, String> headers) {
        this.headers = headers;
    }

    public List<Field> getPayload() {
        return payload;
    }

    public void setPayload(final List<Field> payload) {
        this.payload = payload;
    }

}