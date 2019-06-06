package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.SearchFacesRequest;
import com.tencentcloudapi.iai.v20180301.models.SearchFacesResponse;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
/**
 * 人脸搜索
 * @author John
 *
 */
public class SearchFaces
{
    public static void main(String [] args) {
        try{
        	long start = System.currentTimeMillis();
            Credential cred = new Credential("AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti", "Vq0zoHaq0CFAyZ0J6jJrDPNE7OTNisRx");
            
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);            
            
            IaiClient client = new IaiClient(cred, "", clientProfile);
            FileReader fileReader = new FileReader("E:\\我的文档\\爱尔眼科\\人脸识别\\pic\\p3.jpg");
            byte[] b = fileReader.readBytes();
            String base64 = Base64.encode(b);
            System.out.println(base64);
            String params = "{\"GroupIds\":[\"test\",\"test1\"],\"Image\":\""+base64+"\"}";
            SearchFacesRequest req = SearchFacesRequest.fromJsonString(params, SearchFacesRequest.class);
            
            SearchFacesResponse resp = client.SearchFaces(req);
            
            System.out.println(SearchFacesRequest.toJsonString(resp));
            System.out.println("花费时间"+(System.currentTimeMillis()-start));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}