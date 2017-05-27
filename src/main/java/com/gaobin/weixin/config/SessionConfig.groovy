package com.gaobin.weixin.config

import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/5/27
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
@Configuration
@EnableRedisHttpSession
class SessionConfig {
}
