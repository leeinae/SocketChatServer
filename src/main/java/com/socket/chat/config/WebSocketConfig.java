package com.socket.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //웹 소켓에서 활용될 주소
        registry.addEndpoint("ws-stomp").setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //메시지 구독하는 요청 prefix -> sub
        registry.enableSimpleBroker("/sub");
        //메시지 발행하는 요청 prefix -> pub (전송할 목적지의 prefix)
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
