package com.messanger.dp.distributor;

import com.messanger.dp.component.MessageRecipient;
import com.messanger.dp.model.MessageRecipientType;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Configuration
public class MessageDistributor {

    @Bean
    public Map<MessageRecipientType, MessageRecipient> initMap(List<MessageRecipient> messageRecipientsList) {
        return messageRecipientsList.stream().collect(Collectors.toMap(MessageRecipient::getType, l -> l));

    }
}
