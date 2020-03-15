package com.socket.chat.pubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socket.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RedisSubscriber implements MessageListener {
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            //redis에서 발행된 데이터를 deserialize
            String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            //ChatMessage 객체로 맵핑
            ChatMessage roomMessage = objectMapper.readValue(publishMessage, ChatMessage.class);
            //WebSocket Subscriber에게 채팅 메시지 Send
            messagingTemplate.convertAndSend("/sub/chat/room/"+ roomMessage.getRoomId(), roomMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
