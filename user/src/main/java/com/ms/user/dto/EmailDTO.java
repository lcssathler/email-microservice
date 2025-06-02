package com.ms.user.dto;

import java.util.UUID;

public class EmailDTO {
    private UUID userUUID;
    private String emailTo;
    private String subject;
    private String text;

    public UUID getUserUUID() {
        return userUUID;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }


}
