package com.evergrand;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**s
 * @author ���ධ
 * @create 2020-11-12 13:16
 */
public class Test {
    /**
     * javaʹ�ð����ƶ��ŷ���ӿ� ע:����ֱ�Ӹ����밢�����ṩ�ĵ���ʾ��
     *
     * @return ����SMS��Ӧ��Ϣ
     * @throws ClientException
     *         �ͻ����쳣
     * @date 2018��7��15�� ����9:33:33
     */
    public static SendSmsResponse sendSms() throws ClientException {
        // ���ó�ʱʱ��-�����е���
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        // ��ʼ��ascClient��Ҫ�ļ�������
        final String product = "Dysmsapi";// ����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�
        final String domain = "dysmsapi.aliyuncs.com";// ����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�
        // ���AccessKeyID��
        final String accessKeyId = "your AccessKeyID";
        // ���AccessKeySecret
        final String accessKeySecret = "your AccessKeySecret";
        // ��ʼ��ascClient,��ʱ��֧�ֶ�region�������޸ģ�
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // ��װ�������
        SendSmsRequest request = new SendSmsRequest();
        // ʹ��post�ύ
        request.setMethod(MethodType.POST);
        // ����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,
        // ������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ��
        // ���͹���/�۰�̨��Ϣʱ�����պ����ʽΪ00+��������+���룬�硰0085200000000��
        request.setPhoneNumbers("13500000000,18200000000");
        // ����:����ǩ��-���ڿ���̨�½�������ģ��
        request.setSignName("your ǩ��");
        // ����:����ģ��-���ڿ���̨�½�������ģ��
        request.setTemplateCode("your ģ��code");
        // ��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"������֤��Ϊ${code},5��������Ч���뼰ʱУ��!"ʱ,�˴���ֵΪ
        // ������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,
        // ������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��
        request.setTemplateParam("{\"code\":\"54188\"}");
        // ��ѡ-���ж�����չ��(��չ���ֶο�����7λ�����£������������û�����Դ��ֶ�)
        // request.setSmsUpExtendCode("90997");
        // ��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
        // request.setOutId("yourOutId");
        // ���Ͷ��ŵ�������(�������ʧ��,�������ClientException�쳣)
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("���ŷ��ͳɹ�!");
            return sendSmsResponse;
        }
        System.out.println("���ŷ���ʧ��!");
        return sendSmsResponse;
    }

    /**
     * ���÷��Ͷ��Ź���
     *
     * @param args
     * @date 2018��7��15�� ����11:37:25
     */
    public static void main(String[] args) {
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = Test.sendSms();
            System.out.println("��ʾ��Ϣ����: " + sendSmsResponse.getMessage());
            System.out.println("��ʾ��Ϣ��Ӧ��: " + sendSmsResponse.getCode());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
