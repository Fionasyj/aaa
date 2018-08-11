package com.Fiona.Wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
    
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    
import com.Fiona.Wechat.utils.Message;
import com.Fiona.Wechat.utils.ReplyMessage;
import org.apache.commons.io.IOUtils;
    
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
    
    
public class WeChat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    public WeChat() {
        super();
    }
    /**
     * 验证
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String echo = request.getParameter("echostr");
        System.out.print(echo);
        echo = new String(echo.getBytes("ISO-8859-1"),"UTF-8");
        pw.println(echo);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String wxMsgXml = IOUtils.toString(request.getInputStream(),"utf-8");
        Message textMsg = null;
        try {
            textMsg = getMessage(wxMsgXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer replyMsg = new StringBuffer();
        if(textMsg != null){
            //增加你所需要的处理逻辑，这里只是简单重复消息
            replyMsg.append("您给我的消息是：");
            replyMsg.append(textMsg.getContent());
        }
        else{
            replyMsg.append(":)不是文本的消息，我暂时看不懂");
        }
        String returnXml = getReplyMessage(replyMsg.toString(), textMsg.getFromUserName(),textMsg.getToUserName());
        System.out.print(textMsg.toString());
        System.out.print(returnXml.toString());
        pw.println(returnXml);
    }
    
    private Message getMessage(String xml){
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("xml", Message.class);
        xstream.aliasField("ToUserName", Message.class, "toUserName");
        xstream.aliasField("FromUserName", Message.class, "fromUserName");
        xstream.aliasField("CreateTime", Message.class, "createTime");
        xstream.aliasField("MsgType", Message.class, "messageType");
        xstream.aliasField("Content", Message.class, "content");
        xstream.aliasField("MsgId", Message.class, "msgId");
        Message Message = (Message)xstream.fromXML(xml);
        return Message;
    }
    
    private String getReplyMessage(String replyMsg,String toUserName,String fromUserName){
        ReplyMessage we = new ReplyMessage();
        we.setMessageType("text");
        we.setFuncFlag("0");
        we.setCreateTime(new Long(new Date().getTime()).toString());
        we.setContent(replyMsg);
        we.setToUserName(toUserName);
        we.setFromUserName(fromUserName);
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("xml", ReplyMessage.class);
        xstream.aliasField("ToUserName", ReplyMessage.class, "toUserName");
        xstream.aliasField("FromUserName", ReplyMessage.class, "fromUserName");
        xstream.aliasField("CreateTime", ReplyMessage.class, "createTime");
        xstream.aliasField("MsgType", ReplyMessage.class, "messageType");
        xstream.aliasField("Content", ReplyMessage.class, "content");
        xstream.aliasField("FuncFlag", ReplyMessage.class, "funcFlag");
        String xml =xstream.toXML(we);
        return xml;
    }
    
    
}
    
