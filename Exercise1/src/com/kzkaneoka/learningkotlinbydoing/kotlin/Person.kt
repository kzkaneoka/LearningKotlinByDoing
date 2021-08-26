package com.kzkaneoka.learningkotlinbydoing.kotlin

import java.util.*

data class Person(val id: Long, val title: String, val firstName: String, val lastName: String, val dateOfBirth: Calendar? = null) {
    override fun toString(): String = "$title $firstName $lastName"

    val age: Int
        get() = getAge(dateOfBirth)

    companion object {
        fun getAge(dateOfBirth: Calendar?) : Int {
            if (dateOfBirth == null) return -1
            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) years -1 else years
        }
    }
}