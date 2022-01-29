package com.pirate.practice.repository

import com.pirate.practice.model.visit.Visit
import org.springframework.data.repository.Repository

interface VisitRepository : Repository<Visit, Int> {

    fun save(visit: Visit)

    fun findByPetId(petId: Int): MutableSet<Visit>

}