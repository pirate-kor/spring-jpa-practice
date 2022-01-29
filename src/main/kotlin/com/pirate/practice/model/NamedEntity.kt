package com.pirate.practice.model

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class NamedEntity : BaseEntity() {

    @Column(name = "name")
    open var name: String? = null

    override fun toString(): String =
        this.name ?: ""
}