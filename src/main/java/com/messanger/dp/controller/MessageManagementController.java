package com.messanger.dp.controller;

import com.messanger.dp.model.Message;
import com.messanger.dp.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageManagementController {


    private final MessageSenderService messageSenderService;

    @Autowired
    public MessageManagementController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message) {
        messageSenderService.sendMessage(message);
    }
}
