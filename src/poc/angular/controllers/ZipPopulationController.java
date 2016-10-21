package poc.angular.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poc.angular.dm.Population;

@RestController
public class ZipPopulationController {
	
	@RequestMapping(value="/zippoulation/{zip}", method=RequestMethod.GET)
	public Population getPopulation(@PathVariable("zip")String zip) {
		Population population = new Population();
		population.setCity("Simi Valley");
		population.setTotalPopulation(1000000);
		return population;
	}

}
