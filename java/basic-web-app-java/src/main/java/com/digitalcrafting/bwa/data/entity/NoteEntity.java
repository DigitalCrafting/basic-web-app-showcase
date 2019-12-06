package com.digitalcrafting.bwa.data.entity;

import com.digitalcrafting.base.entitymanager.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity extends AbstractEntity<NotePrimaryKey> {
    private String noteText;
}
