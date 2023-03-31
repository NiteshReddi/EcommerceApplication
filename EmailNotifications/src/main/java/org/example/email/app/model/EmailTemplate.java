package org.example.email.app.model;

import lombok.Data;

@Data
public class EmailTemplate {
    private String toAddress;

    private String subject;

    private String emailBody;

    private Boolean isAttachmentRequired;

    private String filePath;
}
