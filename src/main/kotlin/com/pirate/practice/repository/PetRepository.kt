package com.pirate.practice.repository

import com.pirate.practice.model.owner.Pet
import com.pirate.practice.model.owner.PetType
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface PetRepository : Repository<Pet, Int> {

    @Query("select ptype from PetType ptype order by ptype.name")
    @Transactional(readOnly = true)
    fun findPetTypes(): List<PetType>

    @Transactional(readOnly = true)
    fun findById(id: Int): Pet

    fun save(pet: Pet)

}