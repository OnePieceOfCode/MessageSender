package com.messanger.dp.service;

import com.messanger.dp.model.AddresseeType;
import com.messanger.dp.model.Message;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {


    @Override
    public void sendMessage(Message message) {
        try {
            String addressee = AddresseeType.getById(message.getDeparturePoint());
            System.out.format("Send message to %s", addressee);
        } catch (NoSuchElementException e) {
            e.getCause();
            throw new RuntimeException("This departure point doesn't exist.");
        }
        System.out.println();
    }
}
