package com.Fiona.Wechat.utils;

/**
 * Created with IntelliJ IDEA.
 * User: sb
 * Date: 8/1/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReplyMessage {
    
    private String FuncFlag;//��Ϣ���
    private String fromUserName;//������
    private String toUserName;//������
    private String content;//����
    private String messageType;//��Ϣ����
    private String createTime;//��������
    
    
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
    
    public String getFuncFlag() {
        return FuncFlag;
    }
    
    public void setFuncFlag(String funcFlag) {
        FuncFlag = funcFlag;
    }
    
    public String toString(){
        return "createTime:"+getCreateTime()+"\\ntoUserName:"+getToUserName()+"\\n FromUserName:"+getFromUserName()+"\\nmessageType:"+getMessageType()+"\\ncontent:"+getContent();
    }
}