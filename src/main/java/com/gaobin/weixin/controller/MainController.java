package com.gaobin.weixin.controller;

import com.gaobin.weixin.model.TextMessage;
import com.gaobin.weixin.util.checkUtil;
import com.gaobin.weixin.util.messageUtil;
import org.dom4j.DocumentException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Administrator on 2017-02-20.
 */
@Controller
public class MainController {
    @GetMapping("/")
    public void initWeixinGet(HttpServletRequest req, HttpServletResponse resp){
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (checkUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
    }
    @PostMapping("/")
    public void WeixinPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            Map<String, String> map = messageUtil.xmlToMap(req);
            String ToUserName = map.get("ToUserName");
            String FromUserName = map.get("FromUserName");
            String MsgType = map.get("MsgType");
            String Content = map.get("Content");
            TextMessage text = new TextMessage();
            String message = null;
            if(messageUtil.MESSAGE_TEXT.equals(MsgType)){
                if("1".equals(Content)){
                    message = messageUtil.initText(ToUserName, FromUserName, messageUtil.fristMenu());
                }else if("2".equals(Content)){
                    message = messageUtil.initText(ToUserName, FromUserName, messageUtil.secondMenu());
                } else if ("?".equals(Content) || "？".equals(Content)) {
                    message = messageUtil.initText(ToUserName, FromUserName, messageUtil.menuText());
                }
            } else if (messageUtil.MESSAGE_EVENT.equals(MsgType)) {
                String eventType = map.get("Event");
                if (messageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
                    message = messageUtil.initText(ToUserName, FromUserName, messageUtil.menuText());
                }

            }

            System.out.print(message);
            out.print(message);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
