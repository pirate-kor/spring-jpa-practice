package com.pirate.practice.converter

import com.pirate.practice.dto.OwnerResponse
import com.pirate.practice.model.owner.Owner
import org.springframework.core.convert.converter.Converter

class OwnerEntityConverter: Converter<Owner, OwnerResponse> {
    override fun convert(owner: Owner): OwnerResponse {
        return OwnerResponse(
            owner.id!!,
            owner.firstName,
            owner.lastName
        )
    }

}