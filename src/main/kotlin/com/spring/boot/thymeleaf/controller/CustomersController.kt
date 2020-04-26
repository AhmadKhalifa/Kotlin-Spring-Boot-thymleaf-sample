package com.spring.boot.thymeleaf.controller

import com.spring.boot.thymeleaf.model.Customer
import com.spring.boot.thymeleaf.repository.CustomersRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/customers")
class CustomersController(private val customersRepository: CustomersRepository) {

    @GetMapping(value = ["/home", "/", ""])
    fun sayHello(model: Model) = with(model) {
        addAttribute("customers", customersRepository.findAll())
        "home"
    }

    @GetMapping("/newCustomer")
    fun showNewCustomerForm(model: Model) = with(model) {
        addAttribute("customer", Customer())
        "add-customer"
    }

    @PostMapping("/createCustomer")
    fun createCustomer(@ModelAttribute("customer") customer: Customer): String {
        customersRepository.save(customer)
        return "redirect:/customers/home"
    }

    @GetMapping("/deleteCustomer/{id}")
    fun deleteCustomer(@PathVariable("id") id: Int): String {
        customersRepository.deleteById(id)
        return "redirect:/customers/home"
    }
}