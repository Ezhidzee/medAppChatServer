package su.ezhidze.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import su.ezhidze.server.entity.Chat;
import su.ezhidze.server.entity.Message;
import su.ezhidze.server.entity.User;
import su.ezhidze.server.model.InputMessageModel;
import su.ezhidze.server.repository.ChatRepository;
import su.ezhidze.server.repository.MessageRepository;

import java.util.Objects;

@Service
public class WSService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ChatService chatService;

    @Autowired
    private MessageService messageService;

    @Autowired
    public WSService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(final InputMessageModel message) {
        Chat chat = chatService.getChatById(message.getChatId());
        for (User user : chat.getUsers()) {
            if (user.getIsOnline() && !Objects.equals(user.getEmail(), message.getSenderSubject())) {
                messagingTemplate.convertAndSendToUser(user.getUUID(), "/topic/private-messages", message);
            }
        }
        Integer newMessageId = messageService.addNewMessage(message, chatService).getId();
        chatService.addMessage(chat.getId(), messageService.getMessageById(newMessageId));
    }
}
