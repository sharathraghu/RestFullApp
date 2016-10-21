package poc.test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import poc.angular.dm.Customers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class RestVerify {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testCustomers() {
		String custId = "1234";
		Map<String, String> request = new HashMap<String, String>();
		request.put("id", custId);
		Customers[] customers = restTemplate.getForObject("http://localhost:8080/RestfullApp/services/customers/{id}", Customers[].class, request);
		assertNotNull("no customer",customers);
	}
	
	@Test
	public void saveCustomer(){
		Customers customers = new Customers();
		String response = restTemplate.postForObject("http://localhost:8080/RestfullApp/services/customer", customers, String.class, new Object[]{});
		assertEquals("Saved",response);
	}
	
	/*@Test
	public void testZipPopulation() {
		Map<String, String> req = new HashMap<String, String>();
		req.put("zip", "93065");
		Population population = restTemplate.getForObject("http://localhost:8080/AngularRestPoc/services/zippoulation/{zip}", Population.class, req);
		assertNotNull("No Population",population);
	}*/
}
