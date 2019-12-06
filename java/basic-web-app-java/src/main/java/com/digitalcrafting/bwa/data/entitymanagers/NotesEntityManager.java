package com.digitalcrafting.bwa.data.entitymanagers;

import com.digitalcrafting.base.services.EntityManager;
import com.digitalcrafting.bwa.data.MybatisEntityManager;
import com.digitalcrafting.bwa.data.entity.NoteEntity;
import com.digitalcrafting.bwa.data.entity.NotePrimaryKey;
import com.digitalcrafting.bwa.data.mybatis.NotesMapper;

import java.util.List;

@EntityManager
public class NotesEntityManager extends MybatisEntityManager<NoteEntity, NotePrimaryKey> {
    public NotesEntityManager(NotesMapper notesMapper) {
        super(notesMapper);
    }

    public List<NoteEntity> getUserNotes(String username) {
        return ((NotesMapper)wrappedMapper).getUserNotes(username);
    }
}
