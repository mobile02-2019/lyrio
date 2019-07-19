package com.example.lyrio.Api.BaseVagalume;

import java.util.List;

public class ApiResponse {

    private int numFound;
    private String start;
    private List<ApiItem> docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<ApiItem> getDocs() {
        return docs;
    }

    public void setDocs(List<ApiItem> docs) {
        this.docs = docs;
    }
}
