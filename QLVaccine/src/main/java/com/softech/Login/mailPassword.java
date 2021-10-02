    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.Login;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author admin
 */
public class mailPassword {

    public static void send(Email email) throws Exception {

               Properties prop = new Properties();//cau hinh mail
        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP host
        prop.put("mail.smtp.port", "587"); //TLS Port
        prop.put("mail.smtp.auth", "true"); //enable authentication
        prop.put("mail.smtp.starttls.enable", "true"); //enable 

        Session session = Session.getInstance(prop, new Authenticator() { // lop cho phep thuc hien cac xac thuc khi ket noi voi mail
            protected PasswordAuthentication getPasswordAuthentication() { //email gui mail
                return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom())); // dia chi mail gui 
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo())); // danh sach ng nhan
            message.setSubject(email.getSubject()); // tieu de mail
            message.setContent(email.getContent(), "text/html; charset=utf-8"); // noi dung mail . kieu noi dung va kieu dinh dang

            Transport.send(message);// method send mail
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }
    }

}
