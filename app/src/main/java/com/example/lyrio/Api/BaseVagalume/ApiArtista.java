package com.example.lyrio.Api.BaseVagalume;

import java.util.List;

public class ApiArtista {

    private String desc;
    private String url;
    private String pic_small;
    private String pic_medium;
    private ApiItem toplyrics;

    public ApiItem getToplyrics() {
        return toplyrics;
    }

    public void setToplyrics(ApiItem toplyrics) {
        this.toplyrics = toplyrics;
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

    public String getPic_small() {
        return pic_small;
    }

    public void setPic_small(String pic_small) {
        this.pic_small = pic_small;
    }

    public String getPic_medium() {
        return pic_medium;
    }

    public void setPic_medium(String pic_medium) {
        this.pic_medium = pic_medium;
    }
}
