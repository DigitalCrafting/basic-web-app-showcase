package com.digitalcrafting.base.entitymanager;

public abstract class AbstractEntityManager<E extends AbstractEntity<P>, P extends PrimaryKey> implements HasBasicDbOperations<E, P> {

}
