package com.pirate.practice.web

import com.pirate.practice.dto.OwnerResponse
import com.pirate.practice.service.OwnerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OwnerController(
    private val ownerService: OwnerService
) {

    @GetMapping("/owners/{ownerId}")
    fun showOwner(@PathVariable("ownerId") ownerId: Int): OwnerResponse {
        return ownerService.showOwner(ownerId);
    }

}