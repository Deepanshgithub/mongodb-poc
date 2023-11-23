package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document("note-user-mapping")
public class NoteUserMapping implements Serializable {

  @Id
  private String id;

  @Field("note_id")
  private String noteId;

  @Field("user_id")
  private String userId;

  public NoteUserMapping(){

  }

  public NoteUserMapping(String noteId, String userId) {
    this.noteId = noteId;
    this.userId = userId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNoteId() {
    return noteId;
  }

  public void setNoteId(String noteId) {
    this.noteId = noteId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}