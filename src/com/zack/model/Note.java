package com.zack.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement
@XmlType(propOrder = {"id", "title", "note", "date", "status"})
@Entity
@Table(name="note")
public class Note implements Serializable {
    // member variables
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="note")
    private String note;

    @Column(name="notedate")
    private String date;

    @Column(name="status")
    private String status;


    // getters & setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
