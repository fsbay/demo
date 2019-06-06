package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.CreateGroupRequest;
import com.tencentcloudapi.iai.v20180301.models.CreateGroupResponse;
/**
 * 添加人员库
 * @author John
 *
 */
public class CreateGroup
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
            
            String params = "{\"GroupName\":\"test1\",\"GroupId\":\"test1\",\"GroupExDescriptions\":[\"test1\"]}";
            CreateGroupRequest req = CreateGroupRequest.fromJsonString(params, CreateGroupRequest.class);
            
            CreateGroupResponse resp = client.CreateGroup(req);
            
            System.out.println(CreateGroupRequest.toJsonString(resp));
            System.out.println("花费时间"+(System.currentTimeMillis()-start));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}