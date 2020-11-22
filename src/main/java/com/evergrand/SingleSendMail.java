package com.evergrand;



import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import javax.mail.Message;

public class SingleSendMail{

    private final String host = "smtp.163.com"; // smtp host
    private final int port = 465;
    private final String user = "13214032543@163.com";
    private final String password = "CWINXYYWSEBDSMYL";
    private final String sender = "syd";

    public boolean send(String to, String toName, String body) {
        Email email = new Email();
        email.setFromAddress(sender, user);
        email.setReplyToAddress(sender, user);
        email.addRecipient(toName, to, Message.RecipientType.TO);
        email.setTextHTML(body); //body里写内容
        email.setSubject("hello" + toName + ",我来了!!!");// 标题
        new Mailer(host, port, user, password, TransportStrategy.SMTP_SSL).sendMail(email);
        return true;
    }

    public static void main(String[] args) {

        new SingleSendMail().send("1044800326@qq.com","shenyandong","陆辉是我儿子");
    }
}


