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
    private final FacebookMR facebookMR;
    private final TwitterMR twitterMR;
    private final FaxMR faxMR;
    private final InstagramMR instagramMR;

    @Autowired
    public MessageDistributor(FacebookMR facebookMR, TwitterMR twitterMR, FaxMR faxMR, InstagramMR instagramMR) {
        this.facebookMR = facebookMR;
        this.twitterMR = twitterMR;
        this.faxMR = faxMR;
        this.instagramMR = instagramMR;
    }

    @Configuration
    @ComponentScan("com.messanger.dp.component")
    public class Config {

        @Bean
        public Map<String, MessageRecipient> createMap() {
            messageRecipientMap = new HashMap<>();
            messageRecipientMap.put(MessageRecipientType.FACEBOOK.getId(), facebookMR);
            messageRecipientMap.put(MessageRecipientType.TWITTER.getId(), twitterMR);
            messageRecipientMap.put(MessageRecipientType.FAX.getId(), faxMR);
            messageRecipientMap.put(MessageRecipientType.INSTAGRAM.getId(), instagramMR);
            return messageRecipientMap;
        }
    }
}
