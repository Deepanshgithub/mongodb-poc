package com.example;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("attendance")
public class Attendance {

  private String DateTime;
  @Field("user_name")
  private String email;
  private String technology;
  @Field("files_changed")
  private String filesChanged;


  public String getDateTime() {
    return DateTime;
  }

  public void setDateTime(String dateTime) {
    DateTime = dateTime;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTechnology() {
    return technology;
  }

  public void setTechnology(String technology) {
    this.technology = technology;
  }

  public String getFilesChanged() {
    return filesChanged;
  }

  public void setFilesChanged(String filesChanged) {
    this.filesChanged = filesChanged;
  }
}