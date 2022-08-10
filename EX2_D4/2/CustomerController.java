package com.example.myusercontrollers.Controllers;

import com.example.myusercontrollers.model.Api;
import com.example.myusercontrollers.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

ArrayList <Customer> customerList=new ArrayList<>();
@GetMapping("/customer")
public ArrayList<Customer>getCustomer(){
    return customerList;

}
@PostMapping("/customer")
    public Api addCustomer(@RequestBody Customer customer){
    customerList.add(customer);
    return new Api("Customer added ");
    }
@PutMapping("/customer/{index}")
    public Api updateCustomer(@RequestBody Customer customer, @PathVariable int index){
        customerList.set(index,customer);
        return new Api("Customer updated ");
    }
    @DeleteMapping("/customer/{index}")
    public Api deleteCustomer(@PathVariable int index){
        customerList.remove(index);
        return new Api("Customer deleted ");
    }

    @PostMapping("/customer/deposite")
    public Api deposite(@RequestParam int index, @RequestParam int Balance){
      Customer myCustomer = customerList.get(index);
      int oldBalance=myCustomer.getBalance();
      myCustomer.setBalance(oldBalance+Balance);
      return new Api("Deposite ok !");
    }

    @PostMapping("/customer/withdraw")
    public Api withdraw(@RequestParam int index, @RequestParam int Balance){
        Customer myCustomer = customerList.get(index);
        int oldBalance=myCustomer.getBalance();
        myCustomer.setBalance(oldBalance-Balance);
        return new Api("withdraw ok !");
    }
}
