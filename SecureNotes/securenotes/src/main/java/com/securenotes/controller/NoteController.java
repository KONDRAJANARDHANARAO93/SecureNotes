package com.securenotes.controller;

import com.securenotes.entity.Note;

import com.securenotes.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController
{

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/users/{userId}/notes")
    public Note createNote(@PathVariable Long userId,
                           @RequestBody Note note) {

        return noteService.createNote(userId, note);
    }
    @GetMapping("/users/{userId}/notes")
    public List<Note> getNotesByUser(@PathVariable Long userId) {

        return noteService.getNotesByUser(userId);
    }
    @GetMapping("/notes/{noteId}")
    public Note getNoteById(@PathVariable Long noteId) {

        return noteService.getNoteById(noteId);
    }
    @PutMapping("/notes/{noteId}")
    public Note updateNote(@PathVariable Long noteId,
                           @RequestBody Note note) {

        return noteService.updateNote(noteId, note);
    }
    @DeleteMapping("/notes/{noteId}")
    public String deleteNote(@PathVariable Long noteId) {

        noteService.deleteNote(noteId);
        return "Note deleted successfully";
    }
}