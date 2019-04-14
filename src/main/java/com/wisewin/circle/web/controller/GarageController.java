package com.wisewin.circle.web.controller;

import com.aliyun.oss.OSSClient;
import com.wisewin.circle.entity.dto.ResultDTOBuilder;
import com.wisewin.circle.util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("garage")
public class GarageController {
    @Value("${image_base_url}")
    public String IMAGE_BASE_URL;

    @RequestMapping("test")
    public void test(){
        System.out.println(IMAGE_BASE_URL);
    }

    @RequestMapping("/upImage1")
    @ResponseBody
    public String upImage1(HttpServletResponse response, MultipartFile file0, MultipartFile file1, MultipartFile file2,
                           MultipartFile file3, MultipartFile file4, MultipartFile file5, MultipartFile file6
    ) throws IOException {

        // Endpoint
        String endpoint = IMAGE_BASE_URL;
        // 阿里云主账号AccessKey拥有所有API的访问权限
        String accessKeyId = "LTAIppeA9vC1ExT2";
        String accessKeySecret = "GJoVyi5zd0vTZCkLCdET4GCZ0CWjo3";
        String bucketName = "szq190225"; //目录名


        List<MultipartFile> list = new ArrayList<MultipartFile>(7);
        list.add(file0);
        list.add(file1);
        list.add(file2);
        list.add(file3);
        list.add(file4);
        list.add(file5);
        list.add(file6);


        List<String> ponse = new ArrayList<String>();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
                InputStream inputStream = list.get(i).getInputStream();//FileInputStream("<yourlocalFile>");
                String name = list.get(i).getOriginalFilename().substring(list.get(i).getOriginalFilename().lastIndexOf("."));
                name = UUID.randomUUID().toString() + name;
                ossClient.putObject(bucketName, name, inputStream);
                ponse.add("http://xiaowen1024.oss-cn-beijing.aliyuncs.com/" + name);
            }
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        response.setHeader("Access-Control-Allow-Origin", "*");
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(ponse));

        return json;
    }

}
