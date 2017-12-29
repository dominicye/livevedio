package com.ways.live.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tv")
public class Tv {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer vedioId;

    private String tvUrl;

    private Integer tvNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVedioId() {
        return vedioId;
    }

    public void setVedioId(Integer vedioId) {
        this.vedioId = vedioId;
    }

    public String getTvUrl() {
        return tvUrl;
    }

    public void setTvUrl(String tvUrl) {
        this.tvUrl = tvUrl;
    }

    public Integer getTvNum() {
        return tvNum;
    }

    public void setTvNum(Integer tvNum) {
        this.tvNum = tvNum;
    }
}
