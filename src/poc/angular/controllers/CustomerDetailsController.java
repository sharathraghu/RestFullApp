package poc.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poc.angular.dm.Customers;


@RestController
public class CustomerDetailsController {

	@RequestMapping(value="/customers/{id}", method=RequestMethod.GET)
	public List<Customers> getCustomers(@PathVariable("id") String custId){
		List<Customers> customers = new ArrayList<Customers>();
		Customers customer = new Customers();
		customer.setCustId(1);
		customer.setCustName("Ganesh");
		customer.setAddress("1763 Cochran St #G, Simi Valley, CA, 93065");
		customers.add(customer);
		
		return customers;
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public String saveCustomer(@RequestBody Customers customer) {
		List<Customers> customers = new ArrayList<Customers>();
		customers.add(customer);
		return "Saved";
	}
}
