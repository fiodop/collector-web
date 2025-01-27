package com.collectorWeb.service;

import com.collectorWeb.common.exceptions.FailedToSendMailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private final String mailFrom = "collector-web@mogcommunity.ru";
    private final Logger log = LoggerFactory.getLogger(MailService.class);

    public void sendMail(String to, String subject, String text, boolean isHtml) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            helper.setFrom(mailFrom);

            log.info("Sending email to " + to);
            javaMailSender.send(mimeMessage);
            log.info("Successfully sent email to " + to);

        } catch (MessagingException e){
            throw new FailedToSendMailException(e.getMessage());
        }
    }
}
