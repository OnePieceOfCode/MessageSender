package com.messanger.dp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    private String receiver;
    private String message;
    private String departurePoint;
}
