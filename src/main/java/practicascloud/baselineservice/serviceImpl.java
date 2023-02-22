package practicascloud.baselineservice;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class serviceImpl implements  service{


	public List<List<Float>> inversion(float inicial, float aportacion, 
			float porcentaje, float anosInversion, float rendimiento) throws Exception {
				
		if (inicial < 1000) {
			throw new Exception("La inversion inicial debe ser mayor a 1000");
		}
		if (anosInversion <= 0 ) {
			throw new Exception("Los anos de inversion no pueden ser menores a 0");
		}
		if (inicial < 1000) {
			throw new Exception("El rendimiento de inverison no puede ser menor a 0");
		}
		
		List<Float> anos = new ArrayList<Float>();
		List<Float> saldoInic = new ArrayList<Float>();
		List<Float> aportacion2 = new ArrayList<Float>();
		List<Float> rendimiento2 = new ArrayList<Float>();
		List<Float> saldoFin = new ArrayList<Float>();
		
		for(int i=0; i<anosInversion; i++) {
			anos.add( (float) (i + 1));
			if(i == 0) {
			saldoInic.add(inicial);
			aportacion2.add(aportacion);
			}else {
			saldoInic.add(saldoFin.get(i-1));
			float nuevaAportacion = ((aportacion2.get(i-1))*((porcentaje/100)+1));
			aportacion2.add(nuevaAportacion);
			}
			float nuevoRendimiento = ((saldoInic.get(i)+aportacion2.get(i))*(rendimiento/100));
			rendimiento2.add(nuevoRendimiento);
			float nuevoSaldoFin=((saldoInic.get(i))+aportacion2.get(i)+rendimiento2.get(i));
			saldoFin.add(nuevoSaldoFin);
		}
		
		for (int i = 0; i < anos.size(); i++) {
		    float newValue = (float) Math.ceil(saldoInic.get(i));
		    saldoInic.set(i, newValue);
		    
		    newValue = (float) Math.ceil(aportacion2.get(i));
		    aportacion2.set(i, newValue);
		    
		    newValue = (float) Math.ceil(rendimiento2.get(i));
		    rendimiento2.set(i, newValue);
		    
		    newValue = (float) Math.ceil(saldoFin.get(i));
		    saldoFin.set(i, newValue);
		}
		
		List<List<Float>> inversion = new ArrayList<List<Float>>();
		inversion.add(anos);
		inversion.add(saldoInic);
		inversion.add(aportacion2);
		inversion.add(rendimiento2);
		inversion.add(saldoFin);
		
		return inversion;
	}

}
