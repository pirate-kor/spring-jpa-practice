package com.pirate.practice.repository

import com.pirate.practice.model.visit.Visit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.jvm.Throws

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VisitRepositoryTest(
    @Autowired private val pets: PetRepository,
    @Autowired private val visits: VisitRepository
) {

    @Test
    @Throws(Exception::class)
    fun shouldFindVisitsByPetId() {
        val visits = this.visits.findByPetId(7)
        assertThat(visits.size).isEqualTo(2)
        val visitArr = visits.toTypedArray()
        assertThat(visitArr[0].date).isNotNull
        assertThat(visitArr[0].petId).isEqualTo(7)
    }

    @Test
    fun shouldAddNewVisitForPet() {
        var pet7 = this.pets.findById(7)
        val found = pet7.getVisits().size
        val visit = Visit()
        pet7.addVisit(visit)
        visit.description = "test"
        this.visits.save(visit)
        this.pets.save(pet7)

        pet7 = this.pets.findById(7)
        assertThat(pet7.getVisits().size).isEqualTo(found + 1)
        assertThat(visit.id).isNotNull
    }

}