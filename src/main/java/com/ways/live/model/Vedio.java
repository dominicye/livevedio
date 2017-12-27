package com.ways.live.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="vedio")
public class Vedio {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String vedioUrl;

    private String vedioType;

    private String coverUrl;

    private String coverName;

    private String coverTitle;

    private String coverDescription;

    private String coverLocation;

    private int clickTime;

    private String vedioSortType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public String getVedioType() {
        return vedioType;
    }

    public void setVedioType(String vedioType) {
        this.vedioType = vedioType;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getCoverTitle() {
        return coverTitle;
    }

    public void setCoverTitle(String coverTitle) {
        this.coverTitle = coverTitle;
    }

    public String getCoverDescription() {
        return coverDescription;
    }

    public void setCoverDescription(String coverDescription) {
        this.coverDescription = coverDescription;
    }

    public String getCoverLocation() {
        return coverLocation;
    }

    public void setCoverLocation(String coverLocation) {
        this.coverLocation = coverLocation;
    }

    public int getClickTime() {
        return clickTime;
    }

    public void setClickTime(int clickTime) {
        this.clickTime = clickTime;
    }

    public String getVedioSortType() {
        return vedioSortType;
    }

    public void setVedioSortType(String vedioSortType) {
        this.vedioSortType = vedioSortType;
    }
}
