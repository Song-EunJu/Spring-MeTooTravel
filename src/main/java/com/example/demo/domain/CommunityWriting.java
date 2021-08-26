package com.example.demo.domain;

import java.util.Date;

public class CommunityWriting {
    private Long id; // 글 번호
    private String email; // 작성자 이메일
    private String title; // 글 제목
    private String content; // 글 내용
    private Date currentTime; // 현재시간
    private int like; // 좋아요 개수
    private int delete; // 삭제 여부 --> 0이면 삭제안한 것, 1이면 삭제한 것

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
