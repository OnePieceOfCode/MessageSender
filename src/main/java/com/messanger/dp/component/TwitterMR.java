package com.messanger.dp.component;

import com.messanger.dp.model.Message;
import com.messanger.dp.model.MessageRecipientType;
import org.springframework.stereotype.Component;

@Component
public class TwitterMR implements MessageRecipient {

    @Override
    public String messageCreator (Message message) {
        String receiver = message.getReceiver();
        String text = message.getText();
        return String.format("Send message: %s \nTo %s. Twitter", text, receiver);
    }

    @Override
    public MessageRecipientType getType() {
        return MessageRecipientType.TWITTER;
    }
}
