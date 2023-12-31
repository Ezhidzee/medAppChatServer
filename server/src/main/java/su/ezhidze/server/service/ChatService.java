package su.ezhidze.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.ezhidze.server.entity.*;
import su.ezhidze.server.exception.RecordNotFoundException;
import su.ezhidze.server.model.ChatModel;
import su.ezhidze.server.repository.ChatRepository;
import su.ezhidze.server.repository.DoctorRepository;
import su.ezhidze.server.repository.MessageRepository;
import su.ezhidze.server.repository.PatientRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MessageRepository messageRepository;

    public ChatModel addNewChat() {
        return new ChatModel(chatRepository.save(new Chat()));
    }

    public Chat getChatById(Integer id) {
        return chatRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Chat not found"));
    }

    public ArrayList<ChatModel> getChats() {
        return new ArrayList<>(((Collection<Chat>) chatRepository.findAll()).stream().map(ChatModel::new).toList());
    }

    public ChatModel joinUser(Integer chatId, Integer userId, String role) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RecordNotFoundException("Chat not found"));
        User user = new User();

        if (role.equals("DOCTOR")) {
            Doctor doctor  = doctorRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("Doctor not found"));
            doctor.getChats().add(chat);
            doctorRepository.save(doctor);
            user = doctor;
        } else if (role.equals("PATIENT")) {
            Patient patient = patientRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("Patient not found"));
            patient.getChats().add(chat);
            patientRepository.save(patient);
            user = patient;
        }
        chat.getUsers().add(user);

        return new ChatModel(chatRepository.save(chat));
    }

    public ChatModel deleteUser(Integer chatId, Integer userId, String role) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RecordNotFoundException("Chat not found"));
        User user = new User();

        if (role.equals("DOCTOR")) {
            user = doctorRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("Doctor not found"));
        } else if (role.equals("PATIENT")) {
            user = patientRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("Patient not found"));
        }

        chat.getUsers().remove(user);

        return new ChatModel(chatRepository.save(chat));
    }


    public ChatModel addMessage(Integer chatId, final Message message) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RecordNotFoundException("Chat not found"));

        chat.getMessages().add(message);

        return new ChatModel(chatRepository.save(chat));
    }

    public ChatModel deleteMessage(Integer chatId, Integer messageId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new RecordNotFoundException("Chat not found"));
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new RecordNotFoundException("Message not found"));

        chat.getMessages().remove(message);

        return new ChatModel(chatRepository.save(chat));
    }
}
