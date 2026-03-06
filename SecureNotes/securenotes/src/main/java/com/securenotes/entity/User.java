package com.securenotes.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@Setter
@Getter
@Table(name = "users")
public class User {
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Note> notes;
}