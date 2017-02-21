package com.gaobin.weixin.model
/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 9:34
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
class News {
    private String Title;
    private String Description;
    private String PicUrl;
    private String Url;

    String getTitle() {
        return Title
    }

    void setTitle(String title) {
        Title = title
    }

    String getDescription() {
        return Description
    }

    void setDescription(String description) {
        Description = description
    }

    String getPicUrl() {
        return PicUrl
    }

    void setPicUrl(String picUrl) {
        PicUrl = picUrl
    }

    String getUrl() {
        return Url
    }

    void setUrl(String url) {
        Url = url
    }
}
