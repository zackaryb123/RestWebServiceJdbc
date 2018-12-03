package com.zack.config;

import com.zack.model.Note;
import com.zack.service.NoteService;
import com.zack.service.NoteServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/note")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource {

    private NoteService noteService = new NoteServiceImpl();

    @GET
    public List<Note> getNotes(){
        return noteService.getAllNote();
    }

    @POST
    @Path("/add")
    public Note postNote(Note note) {
        System.out.println(note.toString());
        return noteService.addNote(note);
    }

    @GET
    @Path("/get/{id}")
    public Note getNoteById(@PathParam("id") int id) {
        return noteService.getNoteById(id);
    }

    @PUT
    @Path("/update/{id}")
    public Note updateEmp(@PathParam("id") int id, Note note){
        return noteService.updateNote(id, note);
    }

    @DELETE
    @Path("/delete/{id}")
    public int removeNote(@PathParam ("id") int id ){
        return noteService.deleteNote(id);
    }
}
