package com.coinswap.listenConfig;

import com.netflix.appinfo.InstanceInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Netanel Dadon
 */
@Component
public class EurekaStateListener {
    private final static Logger logger = LoggerFactory.getLogger(EurekaStateListener.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${spark.system.host}")
    private String host;
    @Value("${spark.system.name}")
    private String company;
    @Value("${spark.system.admins}")
    private String admins;
    @Value("${spark.system.admin-phones")
    private String adminPhone;

    @EventListener(condition = "#event.replication=false")
    public void listen(EurekaInstanceCanceledEvent event){
        String message = "Your Service " + event.getAppName() + "\n" + event.getServerId()
                + " Got Disconnected.";
        logger.info(message);
        String [] adminList = admins.split(",");
        for (String s : adminList) {
            //sendEmailMsg(s,message,"Offline Service Notification.");
            logger.info(message);
        }
    }
    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String message = "Your Service " + instanceInfo.getAppName() + "\n" + instanceInfo.getHostName() +
                ":" + instanceInfo.getPort() + "\n ip:"+ instanceInfo.getIPAddr() +" registered.";
        logger.info(message);
        String [] adminList = admins.split(",");
        for (String s : adminList) {
            //sendEmailMsg(s,message,"Start Service Notification.");
            logger.info(message);
        }
    }
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event){
        logger.info("Service {} renewed",event.getServerId() + " " + event.getAppName());
    }
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event){
        logger.info("Registry Started, {} ",System.currentTimeMillis());
    }
    @EventListener
    public void listen(EurekaServerStartedEvent event){
        logger.info("Registration server center started , {}",System.currentTimeMillis());
    }
    @Async
    public void sendEmailMsg(String email,String message,String subject){
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject(company + "-" + subject);
            Map<String,Object> model = new HashMap<>(16);
            model.put("message",message);
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setClassForTemplateLoading(this.getClass(),"/templates");
            Template template = cfg.getTemplate("simpleMessage.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
            helper.setText(html,true);
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
