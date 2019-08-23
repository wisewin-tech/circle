package com.wisewin.circle.util;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtil {

    /**
     * 图片地址进行Base64编码
     * @param imgUrl
     * @return
     */
    public static String image2Base64(String imgUrl) {
        URL url = null;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection httpUrl = null;
        try{
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            is = httpUrl.getInputStream();
            outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串  
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕  
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来  
            while((len=is.read(buffer)) != -1 ){
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
                outStream.write(buffer, 0, len);
            }
            // 对字节数组Base64编码 
            //System.out.println("解压后大小kb："+outStream.toByteArray().length/1024);
            return new BASE64Encoder().encode(outStream.toByteArray());
        }catch (Exception e){
            e.printStackTrace();
        }//下载
        finally{
            if(is !=null) {
                try{
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrl != null) {
                httpUrl.disconnect();
            }
        }
        return imgUrl;
    }
    /**
     * 图片地址转为二进制数组
     * @param imgUrl
     * @return
     */
    public static byte[] imageBase64(String imgUrl) {
        URL url = null;
        InputStream is = null;
        ByteArrayOutputStream outStream = null;
        HttpURLConnection httpUrl = null;
        try{
            url = new URL(imgUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            is = httpUrl.getInputStream();
            outStream = new ByteArrayOutputStream();
            //创建一个Buffer字符串  
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕  
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来  
            while((len=is.read(buffer)) != -1 ){
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
                outStream.write(buffer, 0, len);
            }
            // 对字节数组Base64编码 
            //System.out.println("解压后大小kb："+outStream.toByteArray().length/1024);
            return  outStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }//下载
        finally{
            if(is !=null) {
                try{
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrl != null) {
                httpUrl.disconnect();
            }
        }
        return null;
    }
    public static void main(String[] args) {
    		String str = image2Base64("https://aip.bdstatic.com/portal/dist/1555683028116/ai_images/technology/ocr-cards/vehicle/demo-card-1.jpg");
    		System.out.println(str);
    }
}
