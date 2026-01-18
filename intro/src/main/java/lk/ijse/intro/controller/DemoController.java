package lk.ijse.intro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.intro.dto.Customer;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    public String healthTest() {
        return "Hello Demo Controller";
    }

    @PostMapping("/{pathVariable}")
	public void getPathVariable(@PathVariable String pathVariable) {
		System.out.println("Path Variable: " + pathVariable);
	}

    @PostMapping("/query")
	public void getQueryParam(@RequestParam ("name") String param1, @RequestParam ("city") String param2) {
		System.out.println("Query param1: " + param1);
        System.out.println("Query param2: " + param2);
	}

    @PostMapping("/body")
    public void getRequestBodyData(@RequestBody String reqBodyData) {
        System.out.println("Request body: " + reqBodyData);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getId());
        System.out.println(customer.getName());
        System.out.println(customer.getCity());

        return customer; // must return something
    }


}