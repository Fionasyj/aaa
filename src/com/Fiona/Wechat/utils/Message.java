package com.Fiona.Wechat.utils;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sb
 * Date: 8/1/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    
    private String msgId;//消息编号
    private String fromUserName;//发送人
    private String toUserName;//接收人
    private String content;//内容
    private String messageType;//消息类型
    private String createTime;//创建日期
    
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    public String getFromUserName() {
        return fromUserName;
    }
    
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    
    public String getToUserName() {
        return toUserName;
    }
    
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getMsgId() {
        return msgId;
    }
    
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
    
    public String toString(){
        return "msgId:"+getMsgId()+"\\ncreateTime:"+getCreateTime()+"\\ntoUserName:"+getToUserName()+"\\n FromUserName:"+getFromUserName()+"\\nmessageType:"+getMessageType()+"\\ncontent:"+getContent();
    }
}