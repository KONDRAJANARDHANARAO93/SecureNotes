package com.securenotes.dto;

import java.time.LocalDateTime;

public class NoteResponseDTO {
    private Long id;
    private String title;
    private String content;
    private boolean archived;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long getId(){
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle(){
        return title;

    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getContent() {
        return content;

    }
    public void setContent(String content){
        this.content=content;
    }
    public boolean isArchived(){
        return archived;
    }
    public void setArchived(boolean archived){
        this.archived=archived;

    }
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;

    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt=updatedAt;
    }
}

