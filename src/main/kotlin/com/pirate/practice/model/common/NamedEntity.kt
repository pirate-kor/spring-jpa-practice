package com.pirate.practice.model.common

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
class NamedEntity : BaseEntity() {

    @Column(name = "name")
    var name: String? = null

    override fun toString(): String =
        this.name ?: ""
}