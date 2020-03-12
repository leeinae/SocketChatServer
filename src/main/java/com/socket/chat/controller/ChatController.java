package com.socket.chat.controller;

import com.socket.chat.chatUtil.ChatRoom;
import com.socket.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private final ChatService chatService;

    /*
     *  채팅방 생성
     * @param String name 채팅방 이름
     * @return 패팅방 UUID
     * */
    @PostMapping
    public ChatRoom createRoom(@RequestBody Map<String, String> map) {
        String name = map.get("name");
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
