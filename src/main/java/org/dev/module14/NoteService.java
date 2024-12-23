package org.dev.module14;

import org.dev.module14.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }


    public Note add(Note note) {
        return noteRepository.save(note);
    }


    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }


    public void update(Note note) {
        Note existingNote = noteRepository.findById(note.getId())
                .orElseThrow(() -> new RuntimeException("Note not found"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        noteRepository.save(existingNote);
    }


    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
