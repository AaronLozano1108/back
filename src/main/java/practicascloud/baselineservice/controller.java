package practicascloud.baselineservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    private service inversionService;
    
	@GetMapping("/inversion{inicial}{aportacion}{porcentaje}{anosInversion}{rendimiento}")
	public List<List<Float>> inversion(@RequestParam float inicial,
						@RequestParam(required = false, value="") float aportacion,
						@RequestParam(required = false, value="") float porcentaje,
						@RequestParam float anosInversion,
						@RequestParam float rendimiento) throws Exception {
		return inversionService.inversion(inicial, aportacion, porcentaje, anosInversion, rendimiento);
	}
    
}