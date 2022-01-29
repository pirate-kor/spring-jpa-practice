package com.pirate.practice.repository

import com.pirate.practice.model.owner.Owner
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface OwnerRepository : Repository<Owner, Int> {

    @Query("select distinct owner from Owner owner left join fetch owner.pets where owner.lastName like :lastName%")
    @Transactional(readOnly = true)
    fun findByLastName(lastName: String): Collection<Owner>

    @Query("select owner from Owner owner left join fetch owner.pets where owner.id = :id")
    fun findById(id: Int): Owner

    fun save(owner: Owner)

}