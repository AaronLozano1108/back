package practicascloud.baselineservice;

import java.util.List;


public interface service {
	List<List<Float>> inversion(float inicial,float aportacion,float porcentaje,
			float anosInversion, float rendimiento) throws Exception;
}