package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.CreatePersonRequest;
import com.tencentcloudapi.iai.v20180301.models.CreatePersonResponse;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
/**
 * 创建人员
 * @author John
 *
 */
public class CreatePerson
{
    public static void main(String [] args) {
        try{
        	long start = System.currentTimeMillis();
            Credential cred = new Credential("AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti", "Vq0zoHaq0CFAyZ0J6jJrDPNE7OTNisRx");
            
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);            
            
            IaiClient client = new IaiClient(cred, "ap-beijing", clientProfile);
            FileReader fileReader = new FileReader("E:\\我的文档\\爱尔眼科\\人脸识别\\pic\\d.jpg");
    		byte[] b = fileReader.readBytes();
            String params = "{\"GroupId\":\"test1\",\"PersonName\":\"7\",\"PersonId\":\"7\",\"Image\":\""+Base64.encode(b)+"\"}";
            CreatePersonRequest req = CreatePersonRequest.fromJsonString(params, CreatePersonRequest.class);
            
            CreatePersonResponse resp = client.CreatePerson(req);
            
            System.out.println(CreatePersonRequest.toJsonString(resp));
            System.out.println("花费时间"+(System.currentTimeMillis()-start));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}