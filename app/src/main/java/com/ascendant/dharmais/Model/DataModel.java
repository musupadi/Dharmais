package com.ascendant.dharmais.Model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("id_news")
    @Expose
    @Nullable
    public String id_news;

    @SerializedName("title")
    @Expose
    @Nullable
    public String title;

    @SerializedName("title_eng")
    @Expose
    @Nullable
    public String title_eng;

    @SerializedName("permalink")
    @Expose
    @Nullable
    public String permalink;

    @SerializedName("category")
    @Expose
    @Nullable
    public String category;

    @SerializedName("description")
    @Expose
    @Nullable
    public String description;

    @SerializedName("description_eng")
    @Expose
    @Nullable
    public String description_eng;

    @SerializedName("date")
    @Expose
    @Nullable
    public String date;

    @SerializedName("image")
    @Expose
    @Nullable
    public String image;

    @SerializedName("author")
    @Expose
    @Nullable
    public String author;

    @SerializedName("tag")
    @Expose
    @Nullable
    public String tag;

    @SerializedName("hits")
    @Expose
    @Nullable
    public String hits;

    @SerializedName("status")
    @Expose
    @Nullable
    public String status;

    @Nullable
    public String getId_news() {
        return id_news;
    }

    public void setId_news(@Nullable String id_news) {
        this.id_news = id_news;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getTitle_eng() {
        return title_eng;
    }

    public void setTitle_eng(@Nullable String title_eng) {
        this.title_eng = title_eng;
    }

    @Nullable
    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(@Nullable String permalink) {
        this.permalink = permalink;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(@Nullable String category) {
        this.category = category;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getDescription_eng() {
        return description_eng;
    }

    public void setDescription_eng(@Nullable String description_eng) {
        this.description_eng = description_eng;
    }

    @Nullable
    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    @Nullable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@Nullable String author) {
        this.author = author;
    }

    @Nullable
    public String getTag() {
        return tag;
    }

    public void setTag(@Nullable String tag) {
        this.tag = tag;
    }

    @Nullable
    public String getHits() {
        return hits;
    }

    public void setHits(@Nullable String hits) {
        this.hits = hits;
    }

    @Nullable
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nullable String status) {
        this.status = status;
    }
}
