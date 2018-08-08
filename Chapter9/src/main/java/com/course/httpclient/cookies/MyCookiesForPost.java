package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/8/6 17:42
 */
public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    /**
     * 用来存储cookies信息
     */
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        //拼接url
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookie信息
        cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name:" + name + ", cookie value:" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithCookieForPost() throws IOException {
        //拼接请求地址url
        String testUrl;
        String uri = bundle.getString("postWithCookies.uri");
        testUrl = this.url + uri;
        //声明Client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明post方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject paramJson = new JSONObject();
        paramJson.put("name", "zhangxiaochen");
        paramJson.put("age", "28");
        //设置请求头信息
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(paramJson.toString(), "utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.cookieStore);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应状态码
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //将返回结果字符串转为json对象
        JSONObject resultJson = new JSONObject(result);
        //处理结果，判断返回结果是否符合预期
        String msg = (String) resultJson.get("msg");
        String status = (String) resultJson.get("status");
        Assert.assertEquals("success", msg);
        Assert.assertEquals("ok", status);

    }
}
