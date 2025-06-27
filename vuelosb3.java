package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @param <string>
 * 
 */
public class vuelosb3<string> extends Vuelos {

	public vuelosb3(String nombre, List<Vuelo> vuelos, String origen, String destino, double precio, int numPasajeros,
			int numPlazas, String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super(nombre, vuelos, origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
		// TODO Auto-generated constructor stub
	}
	/*
	 * ## EJERCICIOS
	 * 
	 * En el tipo contenedor **VuelosB3* añada las siguientes operaciones e
	 * impleméntelas exclusivamente con bucles. Tenga en cuenta que el tipo
	 * **VuelosB3** tiene exactamente las mismas propiedades y operaciones que
	 * **Vuelos**, y añade las siguientes. Reutilice mediante herencia **Vuelos**.
	 * 
	 * 1. Devuelve un `Map` que asigne a cada destino el número de vuelos.
	 * 
	 * 2. Devuelve un `Map` que asigne a cada fecha el número de pasajeros.
	 * 
	 * 3. Devuelve un `Map` que asigne a cada destino una lista con los códigos de
	 * los vuelos a ese destino.
	 * 
	 * 4. Devuelve un `Map` que asigne a cada destino un conjunto con las fechas de
	 * vuelos a ese destino con plazas libres.
	 * 
	 * 5. Dado un destino devuelve un SortedSet con las fechas de los vuelos a ese
	 * destino.
	 * 
	 * 6. Devuelve un SortedSet con todos los vuelos ordenados por fecha.
	 * 
	 * 7. Devuelve un SortedSet con todos los vuelos ordenados por orden alfabético
	 * de destino.
	 * 
	 * 8. Reescribe los métodos 1-4 para que devuelvan un `SortedMap`.
	 * 
	 * 9. Devuelve un `SortedMap` de forma que las claves sean los destinos
	 * ordenados por número de caracteres y los valores el número de vuelos a ese
	 * destino.
	 * 
	 * 10. Implemente un método que devuelva cuál es el destino con más vuelos.
	 * 
	 * 11. Implemente un método que devuelva cuál es el día con menos pasajeros.
	 * 
	 * 12. Implemente un método que devuelva un `Map` que asigne a cada destino el
	 * primer vuelo que tenga plazas libres.
	 */
	
	
	
	
	
	
	// * 1. Devuelve un `Map` que asigne a cada destino el número de vuelos.
	
	public Map<String, Integer> getNumeroVuelosPorDestino() {
	    Map<String, Integer> resultado = new HashMap<>();
	    for (Vuelo v : getVuelos()) {
	        String destino = v.getDestino();
	        resultado.put(destino, resultado.getOrDefault(destino, 0) + 1);
	    }
	    return resultado;
	}



//	 * 2. Devuelve un `Map` que asigne a cada fecha el número de pasajeros.

public Map <LocalDate,Integer> AsignarNumeroDePasajeros(){
	Map<LocalDate,Integer> resultado = new HashMap <>(); 
	for (Vuelo v : getVuelos()) {
		int pasajeros = v.getNumPasajeros();
		LocalDate fecha = v.getFecha();
		resultado.put(fecha, resultado.getOrDefault(fecha,0)+ pasajeros);
	}
	return resultado;
	
}


//  5. Dado un destino devuelve un SortedSet con las fechas de los vuelos a ese
//* destino.


public SortedSet<LocalDate> getFechaDestino(String destino){
	SortedSet <LocalDate> resultado = new TreeSet <>();
	for (Vuelo v : getVuelos()) {
	if(v.getDestino().equals(destino)) {
		resultado.add(v.getFecha());
	}}
			return resultado ;
}

//6. Devuelve un SortedSet con todos los vuelos ordenados por fecha.

public SortedSet <Vuelo> getVuelosSorted(){
	SortedSet <Vuelo> resultado = new TreeSet<>(Comparator.comparing(Vuelo::getFecha));
		resultado.addAll(getVuelos());
		return resultado ;
	
	
}

public SortedSet<Vuelo> getVuelosOrdenadosFecha(LocalDate fecha){
	// no need of comparing v comparator  cs we hava comparto vuelo otro 
	// dado una fecha 
	SortedSet <Vuelo> resultado = new TreeSet <>();
	for (Vuelo v : getVuelos()) {
	if(v.getFecha().equals(fecha)) {
		resultado.add(v);
	}}
			return resultado ;
}  



// 7. Devuelve un SortedSet con todos los vuelos ordenados por orden alfabético
//* de destino.

// treeset do the order Naturally 
public SortedSet <Vuelo> getVuelosOrdenadosPorAlphabets (){
	SortedSet<Vuelo> resultado = new TreeSet <>(Comparator.comparing(Vuelo::getDestino));
	resultado.addAll(getVuelos());
	return resultado;
}


/* 9. Devuelve un `SortedMap` de forma que las claves sean los destinos
* ordenados por número de caracteres y los valores el número de vuelos a ese
* destino.
*/

public SortedMap <String,Integer> getOrdenarNumeroCaracterValoresNuemroVuelos(){
	SortedMap<String,Integer> resultado = new TreeMap <>(Comparator.comparing(String::length));
	for (Vuelo v : getVuelos()) {
	String destinos = v.getDestino ();
	resultado.put(destinos, resultado.getOrDefault(destinos, 0)+1);
	} return resultado ;
}
/* 10. Implemente un método que devuelva cuál es el destino con más vuelos.
 */


public String getDestinoConMasVuelos() {
	Map <String,Integer> map= new HashMap <>();
	for (Vuelo v : getVuelos()) {
		String destino = v.getDestino();
		map.put(destino,map.getOrDefault(destino, 0)+ 1);
	}
	
	String resutlado = null ; 
	Integer max = 0;
	//Iterates through the Map entries (each entry is a (destination, count) pair).


	for (Map.Entry<String, Integer> entry:map.entrySet()) {
		if (entry.getValue()>max) {
			max= entry.getValue();
			resutlado= entry.getKey();
		} 
	}
	return resutlado;
}

/* 11. Implemente un método que devuelva cuál es el día con menos pasajeros.
 * 
 */



public LocalDate getDiaConMenosPasajeros() {
	Map <LocalDate,Integer> mapa = new HashMap <>();
	for (Vuelo v : getVuelos ()) {
		LocalDate fechadia = v.getFecha();
		Integer pasejeros = v.getNumPasajeros();

		mapa.put(fechadia, mapa.getOrDefault(fechadia,0 )+ pasejeros);
	}
LocalDate resultado = null ;	
Integer min = 0 ;
	for (Map.Entry<LocalDate, Integer>entry: mapa.entrySet()) {
		if (entry.getValue()<min) {
			min=entry.getValue();
			resultado = entry .getKey();
		} 
	}
	return resultado;
	
	
} 


/* 12. Implemente un método que devuelva un `Map` que asigne a cada destino el
 * primer vuelo que tenga plazas libres.*/


public Map <String,Vuelo> AsignaDestinoAlPrimerVueloConPlazas (){
	Map <String,Vuelo> result = new HashMap <>();
	for (Vuelo v : getVuelos()) {
		String destino = v.getDestino();
		if (v.getNumPlazas()>v.getNumPasajeros()) {
            if (!result.containsKey(destino) || v.getFecha().isBefore(result.get(destino).getFecha())) {
                result.put(destino, v);

            }
		}
		
	}
	return result;
	
	
}



}
