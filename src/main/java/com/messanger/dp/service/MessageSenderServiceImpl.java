package com.messanger.dp.service;

import com.messanger.dp.component.MessageRecipient;
import com.messanger.dp.distributor.MessageDistributor;
import com.messanger.dp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    private final MessageDistributor messageDistributor;

    @Autowired
    public MessageSenderServiceImpl(MessageDistributor messageDistributor) {
        this.messageDistributor = messageDistributor;
    }

    @Override
    public void sendMessage(Message message) {
        try {
            Map<String, MessageRecipient> mapper = messageDistributor.getMessageRecipientMap();
            String newMessage = mapper.get(message.getDeparturePoint()).messageCreator(message);
            System.out.format(newMessage);
        } catch (NullPointerException e) {
            throw new RuntimeException("This departure point doesn't exist.");
        }
        System.out.println();
    }
}
