package com.zack.dao;

import com.zack.model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.zack.dao.DBUtil.getConnection;

public class NoteDaoImpl implements NoteDao {

    public Note addNote(Note note) {
        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO NOTE (ID, TITLE, NOTE, NOTEDATE, STATUS)  VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, note.getId());
            pstmt.setString(2, note.getTitle());
            pstmt.setString(3, note.getNote());
            pstmt.setString(4, note.getDate());
            pstmt.setString(5, note.getStatus());

            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  note;
    }

    public Note getNoteById(int id) {
        Connection conn = getConnection();
        Note note = new Note();

        try {
            PreparedStatement pstmt = conn.prepareStatement("select * from NOTE WHERE ID = ?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setNote(rs.getString(3));
                note.setDate(rs.getString(4));
                note.setStatus(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    public List<Note> getAllNote() {
        Connection conn = getConnection();
        List<Note> notes = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from NOTE");
            while(rs.next()) {
                Note note = new Note();
                note.setId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setNote(rs.getString(3));
                note.setDate(rs.getString(4));
                note.setStatus(rs.getString(5));
                notes.add(note);
            }
            return notes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }


    @Override
    public Note updateNote(int id, Note note) {
        Connection conn = getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE NOTE SET TITLE = ?, NOTE = ?, STATUS = ? WHERE id = ?");
            pstmt.setString(1, note.getTitle());
            pstmt.setString(2, note.getNote());
            pstmt.setString(3, note.getStatus());
            pstmt.setInt(4, id);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }

    @Override
    public int deleteNote(int id) {
        Connection conn = getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("delete FROM NOTE where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
