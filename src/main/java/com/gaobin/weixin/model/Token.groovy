package com.gaobin.weixin.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 * Description: 保存微信accesstoken实体类
 */
@Entity
@Table(name = "token")
class Token {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "access_token")
    String accessToken;

    @Column(name = "save_time")
    Date saveTime;

}
