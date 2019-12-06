package com.digitalcrafting.bwa.data.entity;

import com.digitalcrafting.base.entitymanager.PrimaryKey;

public class NotePrimaryKey implements PrimaryKey {
    private Integer noteId;
    private String username;

    public NotePrimaryKey() {
    }

    public NotePrimaryKey(Integer noteId, String username) {
        this.noteId = noteId;
        this.username = username;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
