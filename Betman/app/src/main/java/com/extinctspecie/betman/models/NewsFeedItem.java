package com.extinctspecie.betman.models;

/**
 * Created by WorkSpace on 29-Jun-17.
 */

public class NewsFeedItem
{
    private String title;
    private String description;
    private String created_at;

    //Empty constructor
    public NewsFeedItem()
    {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
