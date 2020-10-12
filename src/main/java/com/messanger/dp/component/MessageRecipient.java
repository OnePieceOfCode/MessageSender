package com.messanger.dp.component;


import com.messanger.dp.model.Message;
import org.springframework.core.Ordered;

public abstract class MessageRecipient implements Ordered {
   public String messageCreator(Message message) {
      return null;
   }
}
