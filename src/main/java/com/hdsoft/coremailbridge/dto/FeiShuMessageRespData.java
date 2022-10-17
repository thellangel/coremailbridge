package com.hdsoft.coremailbridge.dto;

public class FeiShuMessageRespData {
    private String chat_id;
    private Long create_time;
    private boolean deleted;
    private String message_id;
    private String msg_type;
    private Long update_time;
    private boolean updated;
    private FeiShuMessageSendserDto sender;

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public FeiShuMessageSendserDto getSender() {
        return sender;
    }

    public void setSender(FeiShuMessageSendserDto sender) {
        this.sender = sender;
    }
}
