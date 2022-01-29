package com.pirate.practice.model.owner

import com.pirate.practice.model.common.NamedEntity
import com.pirate.practice.model.visit.Visit
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "pets")
class Pet : NamedEntity() {

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var birthDate: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "type_id")
    var type: PetType? = null

    @ManyToOne
    @JoinColumn(name = "owner_id")
    var owner: Owner? = null

    @Transient
    var visits: MutableSet<Visit> = LinkedHashSet()

    fun getVisits(): List<Visit> =
        visits.sortedWith(compareBy { it.date })

    fun addVisit(visit: Visit) {
        visits.add(visit)
        visit.petId = this.id
    }
}