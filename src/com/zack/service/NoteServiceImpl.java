package com.zack.service;

import com.zack.dao.NoteDao;
import com.zack.dao.NoteDaoImpl;
import com.zack.model.Note;

import java.util.List;

public class NoteServiceImpl implements NoteService{
    private NoteDao noteDao = new NoteDaoImpl();

    @Override
    public Note addNote(Note emp) {
        return noteDao.addNote(emp);
    }

    @Override
    public Note getNoteById(int id) {
        return noteDao.getNoteById(id);
    }

    @Override
    public List<Note> getAllNote() {
        return noteDao.getAllNote();
    }

    @Override
    public Note updateNote(int id, Note note) {
        return noteDao.updateNote(id, note);
    }

    @Override
    public int deleteNote(int id) {
        return noteDao.deleteNote(id);
    }
}
