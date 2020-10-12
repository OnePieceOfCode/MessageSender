package com.messanger.dp.component;

import com.messanger.dp.model.Message;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class FaxMR extends MessageRecipient {

    @Override
    public String messageCreator(Message message) {
        String receiver = message.getReceiver();
        String text = message.getText();
        return String.format("Send message: %s \nTo %s. Fax", text, receiver);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+2;
    }
}
