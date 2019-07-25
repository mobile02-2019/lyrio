package com.example.lyrio.api.BaseVagalume;

import java.util.List;

public class ApiItem {
    private String id;
    private String name;
    private String desc;
    private String url;
    private String turl;
    private String year;
    private String title;
    private String band;
    private String campoTop;
    private String campoBottom;
    private String imgUrl;
    private int lang;
    private String text;
    private List<ApiItem> translate;
    private List<ApiItem> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ApiItem> getTranslate() {
        return translate;
    }

    public void setTranslate(List<ApiItem> translate) {
        this.translate = translate;
    }

    public List<ApiItem> getItem() {
        return item;
    }

    public void setItem(List<ApiItem> item) {
        this.item = item;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCampoTop() {
        return campoTop;
    }

    public void setCampoTop(String campoTop) {
        this.campoTop = campoTop;
    }

    public String getCampoBottom() {
        return campoBottom;
    }

    public void setCampoBottom(String campoBottom) {
        this.campoBottom = campoBottom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
