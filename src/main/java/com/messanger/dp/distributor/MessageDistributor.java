package com.messanger.dp.distributor;

import com.messanger.dp.component.*;
import com.messanger.dp.model.MessageRecipientType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Configuration
public class MessageDistributor {

    private Map<String, MessageRecipient> messageRecipientMap;

    @Autowired
    private List<MessageRecipient> messageRecipientsList;

    @Bean
    public Map<String, MessageRecipient> createMap() {
        messageRecipientMap = new HashMap<>();
        for (int i = 0; i<messageRecipientsList.size(); i++) {
            messageRecipientMap.put(MessageRecipientType.getAddresseeById(i), messageRecipientsList.get(i));
        }
        return messageRecipientMap;

    }
}
