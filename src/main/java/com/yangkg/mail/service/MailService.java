package com.yangkg.mail.service;

;
;

/**
 * 邮件服务接口
 *
 * @author：Kyle.yangkg
 * @create：2017-08-04 上午 11:15
 * ©copyright：www.aisino.com
 */
public interface MailService {
    //发送简单邮件
    void sendSimpleMail(String to, String subject, String content);
    //发送html格式的邮件
    void sendHtmlMail(String to, String subject, String content);
    //发送带附件的邮件
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
