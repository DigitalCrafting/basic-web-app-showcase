package com.digitalcrafting.base.entitymanager;

import com.digitalcrafting.base.exception.MissingImplementationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface HasBasicDbOperations<E extends AbstractEntity, P extends PrimaryKey> {

    Logger logger = LoggerFactory.getLogger(HasBasicDbOperations.class.getName());

    default E getByPrimaryKey(P pk) {
        logger.error("Method getByPrimaryKey(pk) not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }

    default List<E> getAll() {
        logger.error("Method getAll not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }

    default void insert(E entity) {
        logger.error("Method insert(entity) not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }

    default void update(E entity) {
        logger.error("Method update(entity) not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }

    default void delete(E entity) {
        logger.error("Method delete(entity) not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }

    default void delete(P pk) {
        logger.error("Method insert(pk) not implemented in " + this.getClass().getName());
        throw new MissingImplementationException();
    }
}
