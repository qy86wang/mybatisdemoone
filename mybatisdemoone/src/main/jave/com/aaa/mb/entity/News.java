package com.aaa.mb.entity;

import java.util.Date;

/**
 * className:News
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-06 15:58
 */
public class News {
    private  Integer newsId;
    private String title;
    private  String content;
    private Integer typeId;
    private Date addTime;

    //多对一，实体的体现
    private  NewsType newsType;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }
}
