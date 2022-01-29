package com.pirate.practice.model.owner

import com.pirate.practice.model.common.NamedEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "types")
open class PetType : NamedEntity()
