package com.securenotes.service.impl;

import com.securenotes.entity.Note;
import com.securenotes.entity.User;
import com.securenotes.repository.NoteRepository;
import com.securenotes.repository.UserRepository;
import com.securenotes.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Note createNote(Long userId, Note note) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        note.setUser(user);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        return noteRepository.save(note);
    }

    @Override
    public List<Note> getNotesByUser(Long userId) {

        return noteRepository.findByUserId(userId);
    }

    @Override
    public Note getNoteById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @Override
    public Note updateNote(Long noteId, Note note) {
        Note existing = noteRepository.findById(noteId).orElseThrow();
        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
        return noteRepository.save(existing);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}