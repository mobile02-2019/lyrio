package com.example.lyrio.Api.BaseVagalume;

import java.util.List;

public class ApiItem {
    private String id;
    private String desc;
    private String url;
    private String turl;
    private String year;
    private String title;
    private String band;
    private String campoTop;
    private String campoBottom;
    private String imgUrl;
    private List<ApiItem> item;


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
