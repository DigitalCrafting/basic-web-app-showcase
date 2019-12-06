package com.digitalcrafting.bwa.data.mybatis;

import com.digitalcrafting.base.entitymanager.Mapper;
import com.digitalcrafting.bwa.data.entity.StringPrimaryKey;
import com.digitalcrafting.bwa.data.entity.UserEntity;

@BwaDbMapper
public interface UsersMapper extends Mapper<UserEntity, StringPrimaryKey> {

    @Override
    UserEntity getByPrimaryKey(StringPrimaryKey pk);

    @Override
    void insert(UserEntity entity);
}
