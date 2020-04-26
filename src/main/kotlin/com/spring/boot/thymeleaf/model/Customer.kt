package com.spring.boot.thymeleaf.model

import javax.persistence.*

@Entity(name = "customer")
data class Customer(
        @Column(name = "first_name") var firstName: String = "",
        @Column(name = "last_name") var lastName: String = "",
        var email: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN", "unused")
    var id: Int? = null
}