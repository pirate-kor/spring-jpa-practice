package com.pirate.practice.model

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class Person : BaseEntity() {

    @Column(name = "first_name", nullable = false)
    var firstName = ""

    @Column(name = "last_name", nullable = false)
    var lastName = ""
}