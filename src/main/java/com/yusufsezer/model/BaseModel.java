package com.yusufsezer.model;

import java.time.LocalDateTime;

public abstract class BaseModel<T> {

    protected T id;
    protected LocalDateTime createdDate;
    protected LocalDateTime modifiedDate;

    public BaseModel() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
