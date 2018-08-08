package utils;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zhangxiaochen
 * @CreateDate: 2018/7/17 20:22
 */
public class HttpUtils {
    private static final int default_timeout = 15000;

    public static void main(String[] args) throws HttpException, IOException {
        String rs = postAsJson("http://140.210.4.211:8185/recharge/notify/ysb.do", "{ret:\"2\",orderNo:\"8919554967\",tranId:\"BIM201705051204225353644\"}");
        System.out.println(rs);
    }

    public static String get(String url) throws HttpException, IOException{
        return get(url, default_timeout);
    }

    public static String get(String url, int timeout) throws HttpException, IOException{
        HttpClient c = new HttpClient();
        GetMethod m = new GetMethod(url);
        //使用系统提供的默认的恢复策略
        m.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //设置超时的时间
        m.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, timeout);
        c.executeMethod(m);
        return m.getResponseBodyAsString();
    }

    public static String post(String url) throws HttpException, IOException{
        return post(url, null, default_timeout);
    }

    public static String post(String url,Map<String,Object> params) throws HttpException, IOException{
        return post(url, params, default_timeout);
    }

    public static String post(String url,Map<String,Object> params,int timeout) throws HttpException, IOException{
        HttpClient c = new HttpClient();
        PostMethod m = new PostMethod(url);
        //使用系统提供的默认的恢复策略
        m.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //设置超时的时间
        m.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, timeout);
        if(params != null && params.size() > 0){
            HttpMethodParams hmp = new HttpMethodParams();
            for (Map.Entry<String, Object> each : params.entrySet()) {
                hmp.setParameter(each.getKey(), each.getValue());
            }
            m.setParams(hmp);
        }

        c.executeMethod(m);
        return m.getResponseBodyAsString();
    }

    public static String post2(String url,Map<String,Object> paramMap,Map<String, Object> headerMap) throws HttpException, IOException{
        HttpClient c = new HttpClient();
        PostMethod m = new PostMethod(url);
        //使用系统提供的默认的恢复策略
        m.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        if(paramMap != null && paramMap.size() > 0){
            HttpMethodParams hmp = new HttpMethodParams();
            for (Map.Entry<String, Object> each : paramMap.entrySet()) {
                hmp.setParameter(each.getKey(), each.getValue());
            }
            m.setParams(hmp);
        }

        c.executeMethod(m);
        return m.getResponseBodyAsString();
    }

    public static String postAsXml(String url,String textParams) throws HttpException, IOException{
        return postAsType(url, textParams, "application/xml", default_timeout);
    }

    public static String postAsXml(String url,String textParams,int timeout) throws HttpException, IOException{
        return postAsType(url, textParams, "application/xml", timeout);
    }

    public static String postAsJson(String url,String textParams) throws HttpException, IOException{
        return postAsType(url, textParams, "application/json", default_timeout);
    }

    public static String postAsJson(String url,String textParams,int timeout) throws HttpException, IOException{
        return postAsType(url, textParams, "application/json", timeout);
    }

    public static String postAsType(String url,String textParams,String headerType,int timeout) throws HttpException, IOException{
        HttpClient c = new HttpClient();
        PostMethod m = new PostMethod(url);
        //使用系统提供的默认的恢复策略
        m.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //设置超时的时间
        m.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, timeout);
        RequestEntity re = new StringRequestEntity(textParams, headerType, "UTF-8");
        m.setRequestEntity(re);
        c.executeMethod(m);
        return m.getResponseBodyAsString();
    }
}
