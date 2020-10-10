package com.messanger.dp.mapper;

import com.messanger.dp.component.*;
import com.messanger.dp.model.AddresseeType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class CommonMapper {

    private Map<String, MessageCreator> mapper;

    @Autowired
    public CommonMapper(Map<String, MessageCreator> mapper) {
        this.mapper = mapper;
    }

    @Configuration
    public class Config {

        @Bean
        public Map<String, MessageCreator> createMap() {
            mapper = new HashMap<>();
            mapper.put(AddresseeType.FACEBOOK.getId(), new FacebookMessage());
            mapper.put(AddresseeType.TWITTER.getId(), new TwitterMessage());
            mapper.put(AddresseeType.FAX.getId(), new FaxMessage());
            mapper.put(AddresseeType.INSTAGRAM.getId(), new InstagramMessage());
            return mapper;
        }
    }
}
