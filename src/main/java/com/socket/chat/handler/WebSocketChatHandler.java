//package com.socket.chat.handler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.socket.chat.chatUtil.ChatRoom;
//import com.socket.chat.dto.ChatMessage;
//import com.socket.chat.service.ChatService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class WebSocketChatHandler extends TextWebSocketHandler {
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
////        TextMessage textMessage = new TextMessage("Welcome Chatting Server");
////        session.sendMessage(textMessage);
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, chatService);
//    }
//}
