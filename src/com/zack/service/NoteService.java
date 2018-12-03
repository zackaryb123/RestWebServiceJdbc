package com.zack.service;

import com.zack.model.Note;

import java.util.List;

public interface NoteService {
    Note addNote(Note note);

    Note getNoteById(int id);

    List<Note> getAllNote();

    int deleteNote(int id);

    Note updateNote(int id, Note note);
}
