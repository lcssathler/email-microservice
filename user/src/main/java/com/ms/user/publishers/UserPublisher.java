package com.ms.user.publishers;

import com.ms.user.dto.EmailDTO;
import com.ms.user.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessenger(User user) {
        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setUserUUID(user.getId());
        emailDTO.setEmailTo(user.getEmail());
        emailDTO.setSubject("Registration successfully");
        emailDTO.setText(String.format("Hello, %s! You registration was successfully", user.getName()));

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
