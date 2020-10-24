package com.messanger.dp.service;

import com.messanger.dp.component.MessageRecipient;
import com.messanger.dp.model.Message;
import com.messanger.dp.model.MessageRecipientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    private final Map<MessageRecipientType, MessageRecipient> mapper;

    @Autowired
    public MessageSenderServiceImpl(Map<MessageRecipientType, MessageRecipient> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void sendMessage(Message message) {
        MessageRecipientType type = MessageRecipientType.getByAddressee(message.getDeparturePoint());
        String newMessage = mapper.get(type).messageCreator(message);
        System.out.format(newMessage);
        System.out.println();
    }
}
