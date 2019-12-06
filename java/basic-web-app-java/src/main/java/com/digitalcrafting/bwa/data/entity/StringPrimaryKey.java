package com.digitalcrafting.bwa.data.entity;

import com.digitalcrafting.base.entitymanager.PrimaryKey;

public class StringPrimaryKey implements PrimaryKey {
    private String value;

    public StringPrimaryKey() {
    }

    public StringPrimaryKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
