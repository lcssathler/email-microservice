package com.ms.email.dto;

import java.util.UUID;

public record EmailRecordDTO(UUID userUUID,
                             String emailTO,
                             String subject,
                             String text) {

}
