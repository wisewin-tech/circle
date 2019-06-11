//package com.wisewin.circle.web.controller;
//
//import com.wisewin.circle.util.HttpClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.baidu.aip.ocr.AipOcr;
//import okhttp3.Response;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import sun.misc.BASE64Encoder;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Controller
//@RequestMapping("/demo")
//public class DemoController {
//
//    /**
//     *自己去调用url,进行百度识别  对行驶证进行识别  方法二：
//     * 第一步：获取accessToken
//     * 第二步：进行百度识别
//     * @return
//     */
//    @RequestMapping("/getInfo")
//    public void  getInfo(String accessToken){
//        String url="https://aip.baidubce.com/rest/2.0/ocr/v1/vehicle_license?";
//       final String urlPath= url+"access_token=" + accessToken;
//        String imgUrl = "https://aip.bdstatic.com/portal/dist/1555683028116/ai_images/technology/ocr-cards/vehicle/demo-card-1.jpg";//行驶证照片路径
//        String base64 = image2Base64(imgUrl);
//        final Map map=new HashMap();
//        /*  map.put("image",URLEncoder.encode(base64));*/
//        map.put("image",base64);//百度说 图像数据，base64编码后进行urlencode,此处不进行urlencode，
//        // 因为 Response response=new HttpClient().post_Form(urlPath,map);这一步对map中的值做了urlencode处理
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Response response=new HttpClient().post_Form(urlPath,map);
//                    String res =response.body().string();
//                    //取值  方法一    转为JSONObject一层一层取值
//                    JSONObject jb=JSON.parseObject(res);
//                    String words_result=jb.getString("words_result");
//                    JSONObject j=JSON.parseObject(words_result);
//                    String p=j.getString("品牌型号");
//                    String style=j.getString("车辆类型");
//                    String user=j.getString("所有人");
//                    String num=j.getString("号牌号码");
//
//                    //取值  方法二   转为map,再去取值
//                    Map map=new ObjectMapper().readValue(res,Map.class);
//                    Map words= (Map) map.get("words_result");
//                    String s=((Map)words.get("车辆类型")).get("words")+"";
//
//                    if("轿车".contains(style) || "小型客车".contains(style)){//这几种车辆类型可以注册，其他不可以
//
//
//                    }else{
//
//                    }
//                    System.out.println("品牌型号: "+p+" ,车辆类型: "+style+" ,所有人: "+user+" ,号牌号码:"+num);
//                    System.out.println("====================="+res+"               "+response.isSuccessful());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
//
//
//
//    /**
//     * 图片地址进行Base64编码
//     * @param imgUrl
//     * @return
//     */
//    private static String image2Base64(String imgUrl) {
//        URL url = null;
//        InputStream is = null;
//        ByteArrayOutputStream outStream = null;
//        HttpURLConnection httpUrl = null;
//        try{
//            url = new URL(imgUrl);
//            httpUrl = (HttpURLConnection) url.openConnection();
//            httpUrl.connect();
//            httpUrl.getInputStream();
//            is = httpUrl.getInputStream();
//            outStream = new ByteArrayOutputStream();
//            //创建一个Buffer字符串  
//            byte[] buffer = new byte[1024];
//            //每次读取的字符串长度，如果为-1，代表全部读取完毕  
//            int len = 0;
//            //使用一个输入流从buffer里把数据读取出来  
//            while((len=is.read(buffer)) != -1 ){
//                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
//                outStream.write(buffer, 0, len);
//            }
//            // 对字节数组Base64编码 
//            //System.out.println("解压后大小kb："+outStream.toByteArray().length/1024);
//            return new BASE64Encoder().encode(outStream.toByteArray());
//        }catch (Exception e){
//            e.printStackTrace();
//        }//下载
//        finally{
//            if(is !=null) {
//                try{
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(outStream != null) {
//                try {
//                    outStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(httpUrl != null) {
//                httpUrl.disconnect();
//            }
//        }
//        return imgUrl;
//    }
//
//
//    /**
//     * 图片地址转为二进制数组
//     * @param imgUrl
//     * @return
//     */
//    private static byte[] imageBase64(String imgUrl) {
//        URL url = null;
//        InputStream is = null;
//        ByteArrayOutputStream outStream = null;
//        HttpURLConnection httpUrl = null;
//        try{
//            url = new URL(imgUrl);
//            httpUrl = (HttpURLConnection) url.openConnection();
//            httpUrl.connect();
//            httpUrl.getInputStream();
//            is = httpUrl.getInputStream();
//            outStream = new ByteArrayOutputStream();
//            //创建一个Buffer字符串  
//            byte[] buffer = new byte[1024];
//            //每次读取的字符串长度，如果为-1，代表全部读取完毕  
//            int len = 0;
//            //使用一个输入流从buffer里把数据读取出来  
//            while((len=is.read(buffer)) != -1 ){
//                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
//                outStream.write(buffer, 0, len);
//            }
//            // 对字节数组Base64编码 
//            //System.out.println("解压后大小kb："+outStream.toByteArray().length/1024);
//            return  outStream.toByteArray();
//        }catch (Exception e){
//            e.printStackTrace();
//        }//下载
//        finally{
//            if(is !=null) {
//                try{
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(outStream != null) {
//                try {
//                    outStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(httpUrl != null) {
//                httpUrl.disconnect();
//            }
//        }
//        return null;
//    }
//
//}
