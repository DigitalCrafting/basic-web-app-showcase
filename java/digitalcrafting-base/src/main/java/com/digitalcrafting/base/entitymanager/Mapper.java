package com.digitalcrafting.base.entitymanager;

public interface Mapper<E extends AbstractEntity<P>, P extends PrimaryKey> extends HasBasicDbOperations<E, P> {
}
