package com.hdsoft.coremailbridge.dto;

public class MailInfo {
    private String mid;
    private String msid;
    private String fid;
    private String flag;
    private String from;
    private String to;
    private String subject;
    private String size;
    private String date;

    public MailInfo() {

    }

    public MailInfo(String mid, String msid, String fid, String flag, String from, String to, String subject, String size, String date) {
        this.mid = mid;
        this.msid = msid;
        this.fid = fid;
        this.flag = flag;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.size = size;
        this.date = date;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
