package com.digitalcrafting.bwa.data.entitymanagers;

import com.digitalcrafting.base.services.EntityManager;
import com.digitalcrafting.bwa.data.MybatisEntityManager;
import com.digitalcrafting.bwa.data.entity.StringPrimaryKey;
import com.digitalcrafting.bwa.data.entity.UserEntity;
import com.digitalcrafting.bwa.data.mybatis.UsersMapper;

import java.util.List;

@EntityManager
public class UsersEntityManager extends MybatisEntityManager<UserEntity, StringPrimaryKey> {
    public UsersEntityManager(UsersMapper usersMapper) {
        super(usersMapper);
    }
}
