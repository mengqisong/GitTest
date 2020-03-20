package io.mqs.jcartadministrationback.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Component
public class EmailUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void send(String fromEmail,
                     String toEmail,
                     String title,
                     String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(title);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        //todo send messasge to MQ
        logger.info("send email ended");
    }
}
