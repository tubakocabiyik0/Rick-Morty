package com.example.nested_api.model;

import java.util.List;

public class ResultList {
    private List<Results> results=null;

    public ResultList() {
    }

    public ResultList(List<Results> results) {
        this.results = results;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
