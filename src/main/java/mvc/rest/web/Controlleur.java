package mvc.rest.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Controlleur {
	
	@GetMapping(value = "/vehicules")
	public @ResponseBody Vehicule getVehicule() {
		Vehicule vehicule = new Vehicule();
		vehicule.setId(1L);
		vehicule.setCodeInterne("AA-BE-CC");
		vehicule.setImmatriculation("031123");
		return vehicule;
	}
	
	@RequestMapping(value = "/vehicules/{immatriculation}", method = RequestMethod.GET)
	public @ResponseBody Vehicule geVehicule(@PathVariable String immatriculation) {
		Vehicule vehicule = new Vehicule();
		vehicule.setId(1L);
		vehicule.setCodeInterne("AA-BB-CC");
		vehicule.setImmatriculation(immatriculation);
		return vehicule;
	}
	
	@PostMapping("/vehicules")
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Vehicule creerVehicule(@RequestBody Vehicule vehicule) {
	System.out.println("# Véhicule créé: " + vehicule.getCodeInterne() + ", " +
			vehicule.getImmatriculation());
	return vehicule;
	}
}
