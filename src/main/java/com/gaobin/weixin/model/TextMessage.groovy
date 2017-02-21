package com.gaobin.weixin.model
/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
class TextMessage extends BaseMessage{
    private String Content;
    private String MsgId;

    String getContent() {
        return Content
    }

    void setContent(String content) {
        Content = content
    }
}
