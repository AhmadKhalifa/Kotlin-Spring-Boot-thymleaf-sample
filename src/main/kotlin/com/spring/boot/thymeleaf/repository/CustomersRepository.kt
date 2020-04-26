@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.spring.boot.thymeleaf.repository

import com.spring.boot.thymeleaf.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomersRepository : JpaRepository<Customer, Int>