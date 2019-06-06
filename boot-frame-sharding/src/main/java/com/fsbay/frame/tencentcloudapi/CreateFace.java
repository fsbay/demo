package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.CreateFaceRequest;
import com.tencentcloudapi.iai.v20180301.models.CreateFaceResponse;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
/**
 * 添加人脸
 * @author John
 *
 */
public class CreateFace
{
    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti", "Vq0zoHaq0CFAyZ0J6jJrDPNE7OTNisRx");
            
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);            
            
            IaiClient client = new IaiClient(cred, "ap-beijing", clientProfile);
            FileReader fileReader = new FileReader("E:\\我的文档\\爱尔眼科\\人脸识别\\pic\\8.jpg");
            byte[] b = fileReader.readBytes();
            String base64 = Base64.encode(b);
            System.out.println(base64);
            String params = "{\"PersonId\":\"1\",\"Images\":[\""+base64+"\"]}";
            CreateFaceRequest req = CreateFaceRequest.fromJsonString(params, CreateFaceRequest.class);
            
            CreateFaceResponse resp = client.CreateFace(req);
            
            System.out.println(CreateFaceRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}