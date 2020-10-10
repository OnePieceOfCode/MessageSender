package com.messanger.dp.component;

import com.messanger.dp.model.Message;
import org.springframework.stereotype.Component;

@Component
public class FacebookMessage extends MessageCreator {

    @Override
    public String messageCreator(Message message) {
        String receiver = message.getReceiver();
        String text = message.getText();
        return String.format("Send message: %s \nTo %s. Facebook", text, receiver);
    }
}
