package com.gaobin.weixin.util


import groovy.json.JsonSlurper
import org.springframework.core.io.FileSystemResource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/20
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 * Description: 获取相关信息的工具类
 */
class WeixinUtil {
    private static final String APPID = "wx4a9c4f85ebf81d32";
    private static final String SECRET = "6eaee22929aaee51df680a6b9dd0ab80";
    private static final String APIURL = "https://api.weixin.qq.com/cgi-bin/";
  /**
   * @author gaobin
   * @createDate 2017/2/21
   * @description
   * @return token 是json字符串， JsonSlurper slurper=new JsonSlurper() def o=slurper.parseText(token) accesstoken=o["access_token"]
  */
    static String getAccessToken(RestTemplate restTemplate){
        String accesstoken = null
        String token =restTemplate.getForObject("${APIURL}token?grant_type=client_credential&appid=${APPID}&secret=${SECRET}",String);
        JsonSlurper slurper=new JsonSlurper()
        def o=slurper.parseText(token)
        accesstoken=o["access_token"]
        return accesstoken;
    }
    /**
     * @author gaobin
     * @createDate 2017/2/21
     * @description 素材文件上传，获取返回的media_id
     *
    */
    static String uploadAndReturnMediaId(String filePath,String accesstoken,String type,RestTemplate restTemplate){
        File file = new File(filePath)
        if(!file.exists()||file.isFile()){
            throw new IOException("文件不存在")
        }
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("jarFile", resource);
        String str = restTemplate.postForObject("${APIURL}media/upload?access_token=${accesstoken}&type=${type}",param,String)
        JsonSlurper slurper=new JsonSlurper()
        def o=slurper.parseText(str)
        String mediaId=o["media_id"]
        return mediaId;

    }
    /**
     * @author gaobin
     * @createDate 2017/2/21
     * @description 生成菜单
    */
    static String createMenu(String accesstoken,String menu,RestTemplate restTemplate){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8");//解决中文乱码，改写http头的编码格式
        headers.setContentType(type);
        HttpEntity<String> formEntity = new HttpEntity<String>(menu, headers);
        JsonSlurper slurper=new JsonSlurper()
        String str = restTemplate.postForObject("${APIURL}menu/create?access_token=${accesstoken}",formEntity,String)
        def o=slurper.parseText(str)
        int errcode=o["errcode"]
        if(errcode==0){
            return "菜单创建成功"
        }else{
            return "菜单创建失败"
        }
    }

}
