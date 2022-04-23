package com.dreamStore.base

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

@MappedSuperclass
class CommonEntity(
    @Column(name="CREATED_AT")
    var createdAt:LocalDateTime= LocalDateTime.now(),
    @Column(name="MODIFIED_AT")
    var modifiedAt:LocalDateTime = LocalDateTime.now(),
    @Column(name="DELETED")
    var deleted:Boolean=false,
){
    fun deleted(){
        deleted=true
    }

    @PrePersist
    protected fun onCreate() {
        createdAt = LocalDateTime.now()
    }

    @PreUpdate
    protected fun onUpdate() {
        modifiedAt = LocalDateTime.now()
    }

}