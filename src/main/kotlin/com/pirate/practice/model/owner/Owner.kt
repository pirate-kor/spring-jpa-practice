package com.pirate.practice.model.owner

import com.pirate.practice.model.common.Person
import javax.persistence.*
import javax.validation.constraints.Digits
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "owners")
class Owner : Person() {
    @NotEmpty
    @Column(name = "address", nullable = false)
    var address = ""

    @NotEmpty
    @Column(name = "city", nullable = false)
    var city = ""

    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    @Column(name = "telephone", nullable = false)
    var telephone = ""

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
    var pets: MutableSet<Pet> = HashSet()

    fun getPets(): List<Pet> =
        pets.sortedWith(compareBy { it.name })

    fun addPet(pet: Pet) {
        if (pet.isNew) {
            pets.add(pet)
        }
        pet.owner = this
    }

    fun getPet(name: String): Pet? =
        getPet(name, false)

    fun getPet(name: String, ignoreNew: Boolean): Pet? {
        val lname = name.lowercase()
        for (pet in pets) {
            if (!ignoreNew || !pet.isNew) {
                val compName = pet.name?.lowercase()
                if (compName == lname) {
                    return pet
                }
            }
        }
        return null
    }
}