package com.wisewin.circle.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HttpClient {
    private final OkHttpClient client;

    //设置默认字符编码  UTF-8 GBK 等...
    private final String POST_ENCODE_TYPE="UTF-8";
    private final String GET_ENCODE_TYPE="UTF-8";



    public HttpClient() {
        client = new OkHttpClient.Builder()
                // Set Timeout
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                // Set Others
                .build();
    }




    private void toastMsg(Response response) {
    }

    private void toastMsg(String str) {
    }


    /**
     * 生成Request.Builder
     * 带有请求头参数
     */
    private Request.Builder createBuilder(String url, Map<String,String> addHeaderParameters, Map<String,String> setHeaderParameters){
        Request.Builder builder =new Request.Builder().url(url);
        if (addHeaderParameters!=null){//增加header参数
            Set<Map.Entry<String, String>> entrys = addHeaderParameters.entrySet();
            for (Map.Entry entry : entrys) {
                builder.addHeader(entry.getKey()+"",entry.getValue()+"");
            }
        }
        if (setHeaderParameters!=null){//定义header参数
            Set<Map.Entry<String, String>> entrys = setHeaderParameters.entrySet();
            for (Map.Entry entry : entrys) {
                builder.header(entry.getKey()+"",entry.getValue()+"");
            }
        }
        return builder;
    }


    /**
     * 生成Request.Builder,添加的默认的header参数，不同项目需要修改
     */
    private Request.Builder createBuilder(String url){
        Map mapSet=new HashMap();
        mapSet.put("Content-Type","application/x-www-form-urlencoded");
        return createBuilder(url,null,mapSet);
    }




    /**
     * Get请求，使用默认Header设置
     * @param url 请求地址
     * @param getParameters 携带参数
     */
    public Response get(String url,Map getParameters) throws Exception {
        if (getParameters!=null){
            Set<Entry> entrys = getParameters.entrySet();
            int i=0;
            for (Entry entry : entrys) {
                if (i==0){
                    url=url+"?"+entry.getKey()+"="+ formatStringGet(entry.getValue()+"");
                }else {
                    url=url+"&"+entry.getKey()+"="+ formatStringGet(entry.getValue()+"");
                }
                i++;
            }
        }
        Request request = createBuilder(url)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        return response;
    }

    /**
     * Get请求，使用自定义Header设置
     * @param url 请求地址
     * @param getParameters 携带参数
     * @param addHeaderParameters 增加的请求头参数
     * @param setHeaderParameters 修改的请求头参数
     */
    public Response get(String url,Map getParameters,Map<String,String> addHeaderParameters,Map<String,String> setHeaderParameters) throws Exception {
        if (getParameters!=null){
            Set<Entry> entrys = getParameters.entrySet();
            int i=0;
            for (Entry entry : entrys) {
                if (i==0){
                    url=url+"?"+entry.getKey()+"="+ formatStringGet(entry.getValue()+"");
                }else {
                    url=url+"&"+entry.getKey()+"="+ formatStringGet(entry.getValue()+"");
                }
                i++;
            }
        }
        Request request = createBuilder(url,addHeaderParameters,setHeaderParameters)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        return response;
    }








    /**
     * Post 提交字符串，使用默认Header设置
     * @param url
     * @param type
     * @param content
     * @return
     * @throws Exception
     */

    public Response post_String(String url,String type,String content) throws Exception {
        MediaType contentType=MediaType.parse(type);
        Request request = createBuilder(url)
                .post(RequestBody.create(contentType,content))
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        // response.code()+":"response.message()
        return response;
    }

    /**
     * Post 提交字符串，使用自定义Header设置
     * @param url
     * @param type
     * @param content
     * @param addHeaderParameters
     * @param setHeaderParameters
     * @return
     * @throws Exception
     */
    public Response post_String(String url,String type,String content,Map<String,String> addHeaderParameters,Map<String,String> setHeaderParameters) throws Exception {
        MediaType contentType=MediaType.parse(type);
        Request request = createBuilder(url,addHeaderParameters,setHeaderParameters)
                .post(RequestBody.create(contentType,content))
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        // response.code()+":"response.message()
        return response;
    }






    /**
     * Post 提交字表单，使用默认Header设置
     * @param url
     * @param formParameters
     * @return
     * @throws Exception
     */
    public Response post_Form(String url, Map formParameters) throws Exception {
        Builder builder = new Builder();
        Set<Entry> entrys = formParameters.entrySet();
        for (Entry entry : entrys) {
            builder.addEncoded(formatStringPost(entry.getKey()+""),formatStringPost(entry.getValue()+""));
        }
        RequestBody formBody = builder.build();
        Request request =createBuilder(url)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        return response;
    }

    /**
     *  Post 提交字表单，使用自定义Header设置
     * @param url
     * @param formParameters
     * @param addHeaderParameters
     * @param setHeaderParameters
     * @return
     * @throws Exception
     */
    public Response post_Form(String url, Map formParameters,Map<String,String> addHeaderParameters,Map<String,String> setHeaderParameters) throws Exception {
        Builder builder = new Builder();
        Set<Entry> entrys = formParameters.entrySet();
        for (Entry entry : entrys) {
            builder.addEncoded(formatStringPost(entry.getKey()+""),formatStringPost(entry.getValue()+""));
            if ((entry.getValue()+"").length()>1000){
            }else {
            }
        }
        RequestBody formBody = builder.build();

        Request request =createBuilder(url,addHeaderParameters,setHeaderParameters)
                .post(formBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            toastMsg(response);
            throw new IOException("Unexpected Code/响应失败" + response);
        }
        return response;
    }



    private String formatStringGet(String content){
        String fs= "";
        try {
            fs = URLEncoder.encode(content,GET_ENCODE_TYPE);
        } catch (Exception e) {
            return content;
        }
        return fs;
    }



    private String formatStringPost(String content){
        String fs= "";
        try {
            fs = URLEncoder.encode(content,POST_ENCODE_TYPE);
        } catch (Exception e) {
            return content;
        }
        return fs;
    }
}

