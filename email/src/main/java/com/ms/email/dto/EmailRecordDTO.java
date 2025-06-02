package com.ms.email.dto;

import java.util.UUID;

public record EmailRecordDTO(UUID userUUID,
                             String emailTo,
                             String subject,
                             String text) {

}
