package com.example.lyrio.models;

public class Hotspot {

    private String id;
    private String title;
    private String artUrl;
    private String date;
    private String date_fmt;
    private String link;
    private String descr;
    private String pic_src;
    private String art_pic_src;
    private String pic_width;
    private String pic_height;
    private String colors;
    private String type;
    private String musicID;
    private String musTitle;
    private String musUrl;

    public Hotspot(){}

    public Hotspot(String pic_src, String title, String descr, String date_fmt) {
        this.pic_src = pic_src;
        this.title = title;
        this.descr = descr;
        this.date_fmt = date_fmt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_fmt() {
        return date_fmt;
    }

    public void setDate_fmt(String date_fmt) {
        this.date_fmt = date_fmt;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }

    public String getArt_pic_src() {
        return art_pic_src;
    }

    public void setArt_pic_src(String art_pic_src) {
        this.art_pic_src = art_pic_src;
    }

    public String getPic_width() {
        return pic_width;
    }

    public void setPic_width(String pic_width) {
        this.pic_width = pic_width;
    }

    public String getPic_height() {
        return pic_height;
    }

    public void setPic_height(String pic_height) {
        this.pic_height = pic_height;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getMusTitle() {
        return musTitle;
    }

    public void setMusTitle(String musTitle) {
        this.musTitle = musTitle;
    }

    public String getMusUrl() {
        return musUrl;
    }

    public void setMusUrl(String musUrl) {
        this.musUrl = musUrl;
    }
}
