package com.digitalcrafting.bwa.data.mybatis;

import com.digitalcrafting.base.entitymanager.Mapper;
import com.digitalcrafting.bwa.data.entity.NoteEntity;
import com.digitalcrafting.bwa.data.entity.NotePrimaryKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@BwaDbMapper
public interface NotesMapper extends Mapper<NoteEntity, NotePrimaryKey> {
    String TABLE_NAME = "NOTES";

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE username = #{username}")
    @ResultMap("NoteResultMap")
    List<NoteEntity> getUserNotes(String username);

    @Override
    @Select("SELECT * FROM " + TABLE_NAME + " WHERE note_id = #{noteId} AND username = #{username}")
    @ResultMap("NoteResultMap")
    NoteEntity getByPrimaryKey(NotePrimaryKey pk);

    @Override
    void insert(NoteEntity entity);

    @Override
    @Delete("DELETE FROM " + TABLE_NAME + " WHERE note_id = #{noteId} AND username = #{username}")
    void delete(NotePrimaryKey pk);
}
