package com.messanger.dp.component;


import com.messanger.dp.model.Message;
import com.messanger.dp.model.MessageRecipientType;

public interface MessageRecipient {
   String messageCreator(Message message);
   MessageRecipientType getType();
}
