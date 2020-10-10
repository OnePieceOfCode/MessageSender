package com.messanger.dp.distributor;

import com.messanger.dp.component.*;
import com.messanger.dp.model.MessageRecipientType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class MessageDistributor {

    private Map<String, MessageRecipient> messageRecipientMap;

    @Autowired
    public MessageDistributor(Map<String, MessageRecipient> messageRecipientMap) {
        this.messageRecipientMap = messageRecipientMap;
    }

    @Configuration
    @ComponentScan("com.messanger.dp.component")
    public class Config {

        @Bean
        public Map<String, MessageRecipient> createMap() {
            messageRecipientMap = new HashMap<>();
            messageRecipientMap.put(MessageRecipientType.FACEBOOK.getId(), new FacebookMR());
            messageRecipientMap.put(MessageRecipientType.TWITTER.getId(), new TwitterMR());
            messageRecipientMap.put(MessageRecipientType.FAX.getId(), new FaxMR());
            messageRecipientMap.put(MessageRecipientType.INSTAGRAM.getId(), new InstagramMR());
            return messageRecipientMap;
        }
    }
}
