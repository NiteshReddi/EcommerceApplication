package main.app.model;

public class EmailTemplate {
    private String toAddress;

    private String subject;

    private String emailBody;

    private Boolean isAttachmentRequired;

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public Boolean getIsAttachmentRequired() {
		return isAttachmentRequired;
	}

	public void setIsAttachmentRequired(Boolean isAttachmentRequired) {
		this.isAttachmentRequired = isAttachmentRequired;
	}
    
    
}
