package com.digitalcrafting.bwa.data;

import com.digitalcrafting.base.entitymanager.AbstractEntity;
import com.digitalcrafting.base.entitymanager.AbstractEntityManager;
import com.digitalcrafting.base.entitymanager.Mapper;
import com.digitalcrafting.base.entitymanager.PrimaryKey;

import java.util.List;

public abstract class MybatisEntityManager<E extends AbstractEntity<P>, P extends PrimaryKey> extends AbstractEntityManager<E, P> {
    protected Mapper<E, P> wrappedMapper;

    public MybatisEntityManager(Mapper<E, P> wrappedMapper) {
        this.wrappedMapper = wrappedMapper;
    }

    @Override
    public E getByPrimaryKey(P pk) {
        return wrappedMapper.getByPrimaryKey(pk);
    }

    @Override
    public List<E> getAll() {
        return wrappedMapper.getAll();
    }

    @Override
    public void insert(E entity) {
        wrappedMapper.insert(entity);
    }

    @Override
    public void update(E entity) {
        wrappedMapper.update(entity);
    }

    @Override
    public void delete(E entity) {
        wrappedMapper.delete(entity);
    }

    @Override
    public void delete(P pk) {
        wrappedMapper.delete(pk);
    }
}
