package com.fsbay.frame.tencentcloudapi;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.iai.v20180301.IaiClient;

import com.tencentcloudapi.iai.v20180301.models.DetectLiveFaceRequest;
import com.tencentcloudapi.iai.v20180301.models.DetectLiveFaceResponse;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;
/**
 * 人脸静态活体检测接口
 * @author John
 * 用于对用户上传的静态照片进行人脸活体检测。
 * 与动态活体检测的区别是：静态活体检测中，用户不需要通过唇语或摇头眨眼等动作来识别
 *活体打分，取值范围 [0,100]，分数一般落于[80, 100]区间内，0分也为常见值。
 *推荐相大于 87 时可判断为活体。可根据具体场景自行调整阈值。
 */
public class DetectLiveFace
{
    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKID30sZ8AqkKoCTceGkvthMq9In9tPiY3Ti", "Vq0zoHaq0CFAyZ0J6jJrDPNE7OTNisRx");
            
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);            
            
            IaiClient client = new IaiClient(cred, "ap-beijing", clientProfile);
            FileReader fileReader = new FileReader("E:\\我的文档\\爱尔眼科\\人脸识别\\pic\\7.jpg");
            byte[] b = fileReader.readBytes();
            String base64 = Base64.encode(b);
            System.out.println(base64);
            String params = "{\"Image\":\""+base64+"\"}";
            DetectLiveFaceRequest req = DetectLiveFaceRequest.fromJsonString(params, DetectLiveFaceRequest.class);
            
            DetectLiveFaceResponse resp = client.DetectLiveFace(req);
            
            System.out.println(DetectLiveFaceRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
                System.out.println(e.toString());
        }

    }
    
}