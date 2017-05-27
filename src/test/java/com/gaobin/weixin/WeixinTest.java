package com.gaobin.weixin;

import com.gaobin.weixin.util.WeixinUtil;
import com.gaobin.weixin.util.messageUtil;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinTest {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    private final static String tokenName = "pinche_token_name";

    @Test
    public void getaccessToken(){
        RestTemplate restTemplate= new RestTemplate();
        System.out.print(WeixinUtil.getAccessToken(restTemplate,tokenName,redisTemplate));
    }
    @Test
    public void testCreateMenu() throws JSONException {
        RestTemplate restTemplate= new RestTemplate();
        String str = WeixinUtil.createMenu(WeixinUtil.getAccessToken(restTemplate,tokenName,redisTemplate), messageUtil.intiMenu(),restTemplate);
        System.out.print(str);

    }

    @Test
    public void setString(){
        redisTemplate.opsForValue().set("name","gaobin");
        String value = redisTemplate.opsForValue().get("name");
        Assert.assertEquals("gaobin",value);
    }
    @Test
    public void setList(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i<5;i++){
            String val = "uid"+i;
            list.add(val);
        }
        redisTemplate.opsForList().rightPushAll("list",list);

    }
    @Test
    public void setSet(){
        redisTemplate.opsForSet().add("setkey","aaa");
        String setValue = redisTemplate.opsForSet().pop("setKey");

    }

}

