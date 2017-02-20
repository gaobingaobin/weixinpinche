package com.gaobin.weixin.util;


import com.gaobin.weixin.model.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-11-05.
 */
public class messageUtil {
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

   /**
    * xml转Map
    */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for (Element e:list){
            map.put(e.getName(),e.getText());
        }
        ins.close();
        return map;

    }
 /**
  * 将对象转为xml
       */
    public static String textMessageToXml(TextMessage textMessage){
        XStream xstrem = new XStream();
        xstrem.alias("xml",textMessage.getClass());
        return xstrem.toXML(textMessage);
    }
    /**
     * 主菜单
     *
    */
    public static String menuText(){
        StringBuilder sb = new StringBuilder();
        sb.append("欢迎您关注，请按照菜单提示进行操作：\n\n");
        sb.append("1 课程介绍\n" );
        sb.append("2 公众号介绍\n\n" );
        sb.append("回复？调出此菜单");
        return sb.toString();
    }
   /**
    *
    */
    public static String initText(String toUserName, String fromUserName, String content){
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(messageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return textMessageToXml(text);

    }

    public static  String fristMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("果子是逗比");
        return sb.toString();
    }
    public static  String secondMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("第一次尝试微信公众号开发");
        return sb.toString();
    }
}
