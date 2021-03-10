package com.example.nested_api.model;

import java.util.List;

public class Results {
    private String url;
    private String id;
    private String name;
    private String episode;
    private List<String > characters;

    public Results() {
    }

    public Results(String url, String id, String name, String episode, List characters) {
        this.url = url;
        this.id = id;
        this.name = name;
        this.episode = episode;
        this.characters=characters;
    }

    public List getCharacters() {
        return characters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
