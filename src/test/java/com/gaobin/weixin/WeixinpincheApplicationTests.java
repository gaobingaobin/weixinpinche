package com.gaobin.weixin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinpincheApplicationTests {
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
	}
    @Test
	public void setString(){
		redisTemplate.opsForValue().set("name","gaobin");
		String value = redisTemplate.opsForValue().get("name");
		Assert.assertEquals("gaobin",value);
	}
}
