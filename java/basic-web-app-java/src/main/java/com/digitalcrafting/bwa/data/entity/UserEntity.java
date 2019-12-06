package com.digitalcrafting.bwa.data.entity;

import com.digitalcrafting.base.entitymanager.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEntity extends AbstractEntity<StringPrimaryKey> {
    private String passwordHash;
    private String firstName;
    private String lastName;
}
