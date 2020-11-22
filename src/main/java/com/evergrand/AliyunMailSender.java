package com.evergrand;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
/**
 * @author ���ධ
 * @create 2020-11-12 13:35
 */
public class AliyunMailSender {
    public boolean send(String to, String toName, String body) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your accessKey>", "<your accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName("<����̨�����ķ��ŵ�ַ>");
            request.setFromAlias("����ʼ�"); //�����˵��ǳ�
            request.setAddressType(1);
            request.setTagName("<����̨�����ı�ǩ>");
            request.setReplyToAddress(true);
            request.setToAddress(to);
            request.setSubject("���" + toName + ",����һ�����Բ���ʼǵ��ʼ�!!!");
            request.setHtmlBody(body);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            System.out.println("res:" + httpResponse.toString());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }

}
