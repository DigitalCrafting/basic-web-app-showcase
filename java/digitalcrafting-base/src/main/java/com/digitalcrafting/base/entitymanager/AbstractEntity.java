package com.digitalcrafting.base.entitymanager;

public abstract class AbstractEntity<P extends PrimaryKey> {

    protected P pk;

    public void setPrimaryKey(P pk) {
        this.pk = pk;
    }

    public P getPrimaryKey() {
        return pk;
    }
}
