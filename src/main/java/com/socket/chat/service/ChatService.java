/*
* ChatRoomRepository가 ChatServic의 역할을 포함하기때문에 주석 처리
* */

/*
package com.socket.chat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socket.chat.chatUtil.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    */
/*
    * 모든 채팅방 조회
    * *//*

    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRooms.values());
    }

    */
/*
    * roomId로 채팅방 조회
    * *//*

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    */
/*
    * 채팅방 생성
    * UUID로 패팅방 식별
    * *//*

    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .name(name)
                .build();
        chatRooms.put(randomId, chatRoom);
        return chatRoom;
    }

    */
/*
    * 메시지 발송
    * WebSocketSession에 메시지 발송
    * *//*

    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
*/
