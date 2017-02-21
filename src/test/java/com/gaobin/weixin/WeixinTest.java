package com.gaobin.weixin;

import com.gaobin.weixin.util.WeixinUtil;
import com.gaobin.weixin.util.messageUtil;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class WeixinTest {

    @Test
    public void getaccessToken(){
        RestTemplate restTemplate= new RestTemplate();
        System.out.print(WeixinUtil.getAccessToken(restTemplate));
    }
    @Test
    public void testCreateMenu(){
        RestTemplate restTemplate= new RestTemplate();
        String str = WeixinUtil.createMenu(WeixinUtil.getAccessToken(restTemplate), messageUtil.intiMenu(),restTemplate);
        System.out.print(str);

    }

}

