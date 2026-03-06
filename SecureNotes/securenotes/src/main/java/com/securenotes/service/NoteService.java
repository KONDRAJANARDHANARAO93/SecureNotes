package com.securenotes.service;

import com.securenotes.entity.Note;

import java.util.List;


public interface NoteService {

    Note createNote(Long userId, Note note);

    List<Note> getNotesByUser(Long userId);
    Note getNoteById(Long noteId);
    Note updateNote(Long noteId, Note note);

    void deleteNote(Long noteId);

}