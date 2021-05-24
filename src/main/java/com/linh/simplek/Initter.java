package com.linh.simplek;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

// Runs after Spring context is initialized
@Component
public class Initter implements InitializingBean {
    private static final Logger LOG
            = Logger.getLogger(String.valueOf(Initter.class));

    @Autowired
    private Sender sender;

//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        LOG.info("Initter: onApplicationEvent");
//    }

    public void init(){
        LOG.info("Initter: init() called");
        System.out.println("Initter: init() called");
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("PostConstruct");
        System.out.println("PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("afterPropertiesSet");
        System.out.println("afterPropertiesSet");

        Runnable r = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                int count = 0;
                while(true){
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    sender.send(formatter.format(date) + " Hello counter = " + count++);
                    Thread.sleep(5000);
                }
            }
        };
        new Thread(r).start();
        System.out.println("afterPropertiesSet started background sender thread!!!!");
    }
}
