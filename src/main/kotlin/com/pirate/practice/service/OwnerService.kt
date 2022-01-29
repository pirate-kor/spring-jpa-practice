package com.pirate.practice.service

import com.pirate.practice.dto.OwnerResponse
import com.pirate.practice.repository.OwnerRepository
import com.pirate.practice.repository.VisitRepository
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Service

@Service
class OwnerService(
    val owners: OwnerRepository,
    val visits: VisitRepository,
    val conversionService: ConversionService
) {
    fun showOwner(ownerId: Int) : OwnerResponse {
        val owner = this.owners.findById(ownerId)
        for (pet in owner.getPets()) {
            pet.visits = visits.findByPetId(pet.id!!)
        }

        return conversionService.convert(owner, OwnerResponse::class.java)!!
    }
}