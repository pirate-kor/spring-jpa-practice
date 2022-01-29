package com.pirate.practice.model.visit

import com.pirate.practice.model.common.BaseEntity
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "visits")
class Visit : BaseEntity() {
    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate = LocalDate.now()

    @NotEmpty
    @Column(name = "description", nullable = false)
    var description: String? = null

    @Column(name = "pet_id")
    var petId: Int? = null
}