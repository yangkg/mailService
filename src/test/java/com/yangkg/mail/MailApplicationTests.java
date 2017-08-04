package com.yangkg.mail;

import com.yangkg.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {
    @Autowired
    private MailService mailService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("1228073484@qq.com", "test simple mail", " hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("1228073484@qq.com", "test simple mail", content);
    }


    @Test
    public void sendAttachmentsMail() {
        String filePath = "C:\\Users\\Administrator\\Desktop\\yangkg.txt";
        mailService.sendAttachmentsMail("1228073484@qq.com", "主题：带attachment的邮件", "有attachment，请注意查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Administrator\\Desktop\\1awp6.png";

        mailService.sendInlineResourceMail("1228073484@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        TemplateEngine templateEngine = new TemplateEngine();
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("1228073484@qq.com","主题：这是模板邮件",emailContent);
    }


}

