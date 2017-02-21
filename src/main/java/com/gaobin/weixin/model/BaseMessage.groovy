package com.gaobin.weixin.model
/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 9:33
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
class BaseMessage {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;

    String getToUserName() {
        return ToUserName
    }

    void setToUserName(String toUserName) {
        ToUserName = toUserName

    }

    String getFromUserName() {
        return FromUserName
    }

    void setFromUserName(String fromUserName) {
        FromUserName = fromUserName
    }

    Long getCreateTime() {
        return CreateTime
    }

    void setCreateTime(Long createTime) {
        CreateTime = createTime
    }

    String getMsgType() {
        return MsgType
    }

    void setMsgType(String msgType) {
        MsgType = msgType
    }
}
