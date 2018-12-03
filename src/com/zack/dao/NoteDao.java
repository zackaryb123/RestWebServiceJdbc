package com.zack.dao;

import com.zack.model.Note;

import java.util.List;

public interface NoteDao {
    Note addNote(Note note);
    Note getNoteById(int id);
    List<Note> getAllNote();
    Note updateNote(int id, Note note);
    int deleteNote(int id);
}
