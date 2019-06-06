package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.CompareFaceRequest;
import com.tencentcloudapi.iai.v20180301.models.CompareFaceResponse;

/**
 * 人脸比对
 * @author John
 *
 */
public class CompareFace
{
    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti", "AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti");
            
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);            
            
            IaiClient client = new IaiClient(cred, "ap-beijing", clientProfile);
            
            String params = "{\"ImageA\":\"1111\",\"ImageB\":\"11111\"}";
            CompareFaceRequest req = CompareFaceRequest.fromJsonString(params, CompareFaceRequest.class);
            
            CompareFaceResponse resp = client.CompareFace(req);
            
            System.out.println(CompareFaceRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}