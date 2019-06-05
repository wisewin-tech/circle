package com.wisewin.circle.service;
//
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.List;
//import java.util.Map;
//
///**
// * 获取token类
// */
//public class AuthService {
//
//    /**
//     * 获取权限token
//     * @return 返回示例：
//     * {
//     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
//     * "expires_in": 2592000
//     * }
//     */
//    public static String getAuth() {
//        // 官网获取的 API Key 更新为你注册的
//        String clientId = "百度云应用的AK";
//        // 官网获取的 Secret Key 更新为你注册的
//        String clientSecret = "百度云应用的SK";
//        return getAuth(clientId, clientSecret);
//    }
//
//    /**
//     * 获取API访问token
//     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
//     * @param ak - 百度云官网获取的 API Key
//     * @param sk - 百度云官网获取的 Securet Key
//     * @return assess_token 示例：
//     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
//     */
//    public static String getAuth(String ak, String sk) {
//        // 获取token地址
//        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
//        String getAccessTokenUrl = authHost
//                // 1. grant_type为固定参数
//                + "grant_type=client_credentials"
//                // 2. 官网获取的 API Key
//                + "&client_id=" + ak
//                // 3. 官网获取的 Secret Key
//                + "&client_secret=" + sk;
//        try {
//            URL realUrl = new URL(getAccessTokenUrl);
//            // 打开和URL之间的连接
//            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.err.println(key + "--->" + map.get(key));
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String result = "";
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//            /**
//             * 返回结果示例
//             */
//            System.err.println("result:" + result);
//            JSONObject jsonObject = new JSONObject(result);
//            String access_token = jsonObject.getString("access_token");
//            return access_token;
//        } catch (Exception e) {
//            System.err.printf("获取token失败！");
//            e.printStackTrace(System.err);
//        }
//        return null;
//    }
//
//}





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.wisewin.circle.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.codec.binary.Base64.encodeBase64;



/**
 * 使用APPCODE进行云市场ocr服务接口调用
 */

public class AuthService {

    /*
     * 获取参数的json对象
     */
    public static JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args){

        String host = "https://dm-52.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_driver_license.json";
        String appcode = "你的APPCODE";
        String imgFile = "图片路径";
        Boolean is_old_format = false;//如果文档的输入中含有inputs字段，设置为True， 否则设置为False
        //请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();
        configObj.put("side", "face");
        String config_str = configObj.toString();
        //            configObj.put("min_size", 5);
        //            String config_str = "";

        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);

        Map<String, String> querys = new HashMap<String, String>();

        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            File file = new File(imgFile);
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();
            imgBase64 = new String(encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            if(is_old_format) {
                JSONObject obj = new JSONObject();
                obj.put("image", getParam(50, imgBase64));
                if(config_str.length() > 0) {
                    obj.put("configure", getParam(50, config_str));
                }
                JSONArray inputArray = new JSONArray();
                inputArray.add(obj);
                requestObj.put("inputs", inputArray);
            }else{
                requestObj.put("image", imgBase64);
                if(config_str.length() > 0) {
                    requestObj.put("configure", config_str);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String bodys = requestObj.toString();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return;
            }

            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            if(is_old_format) {
                JSONArray outputArray = res_obj.getJSONArray("outputs");
                String output = outputArray.getJSONObject(0).getJSONObject("outputValue").getString("dataValue");
                JSONObject out = JSON.parseObject(output);
                System.out.println(out.toJSONString());
            }else{
                System.out.println(res_obj.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}