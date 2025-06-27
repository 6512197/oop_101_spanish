package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VuelosB2 extends Vuelos {

	
	
	private Vuelo v;

	public VuelosB2(String nombre, List<Vuelo> vuelos, String origen, String destino, double precio, int numPasajeros,
			int numPlazas, String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super(nombre, vuelos, origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
	
	}

	/*
	 * 1. Dada una cadena de caracteres con un destino devuelve el número total de
	 * pasajeros a ese destino
	 * 
	 * 2. Dada una cadena de caracteres s devuelve el número total de pasajeros de
	 * los destinos que tienen como prefijo s (esto es, comienzan por s).
	 * 
	 * 3. Dado un destino devuelve la recaudación de los vuelos a ese destino.
	 * 4.	Dado un destino devuelve el vuelo a ese destino con menor fecha.

5.	Dado un destino devuelve el vuelo a ese vuelo a ese destino  con menor fecha y de menor precio.

6.	Dado un destino devuelve el código del pvuelo a ese destino con mejor fecha y con plazas libres.

7.	Dada una fecha f devuelve el conjunto de destinos diferentes de todos los vuelos de fecha f.

8.	Dado un precio, ¿existe algún vuelo por debajo de ese precio?

9.	Dado un porcentaje de ocupación ¿Están todos los vuelos por encima de ese porcentaje?

10.	¿Cuál es el vuelo con menor ocupación?

11.	Dado un destino ¿Cuál es el vuelo más barato a ese destino?

12.	Dada una fecha f devuelve el precio medio de los vuelos con salida posterior a f. Si no hubiera vuelos devuelve 0.0

13.	Dado un destino, devuelve una lista con los vuelos a ese destino ordenados por precio (ascendentemente).
	 */
	
   public int getnuemeroTotalDePasajeros(String destino) {
	int Total = 0;
	for (Vuelo v : getVuelos()) {
		if (v.getDestino().equals(destino));
		Total+= v.getNumPasajeros();
	}
	return Total ;
	
}
   
   
   public Integer getnumeroTotalDePajerosConPrefijo (String prefijo) {
	   int TotalPrefijo = 0 ;
	   for (Vuelo v : getVuelos()) {
		   if (v.getDestino().startsWith(prefijo));
		   TotalPrefijo += v.getNumPasajeros();
			   
		   
	   }
	return TotalPrefijo ;
	   
   }
   
   
   public Double getRecaudation (String destino) {
	   double TotalRec = 0.0 ; 
	   for (Vuelo v : getVuelos ()) {
		   if (v.getDestino().equals(destino));
		   TotalRec += v.getPrecio()*v.getNumPasajeros();
	   }
	return TotalRec;
	   
   }
   
   //5.	Dado un destino devuelve el vuelo a ese vuelo a ese destino  con menor fecha y de menor precio.

   public Vuelo getPrimerVueloDestinoMenorPrecio(String destino) {
	    Vuelo resultado = null;
	    for (Vuelo v : getVuelos()) {
	        if (v.getDestino().equals(destino)) {
	            if (resultado == null) {
	                resultado = v;
	            } else {
	                // Si la fecha de v es anterior a la fecha del resultado, actualizo resultado
	                if (v.getFecha().isBefore(resultado.getFecha())) {
	                    resultado = v;
	                } 
	                // Si las fechas son iguales, elijo el que tenga menor precio
	                else if (v.getFecha().equals(resultado.getFecha()) && v.getPrecio() < resultado.getPrecio()) {
	                    resultado = v;
	                }
	            }
	        }
	    }
	    return resultado;
	}

   
// 6 Dado un destino devuelve el código del pvuelo a ese destino con mejor fecha y con plazas libres.
   

   public String getCodigocConMejFyPlazasLibres (String destino) {
	   Vuelo resultado = null ;
	   for(Vuelo v : getVuelos()) {
		   if (v.getDestino().equals(destino) && v.getNumPasajeros()<v.getNumPlazas()) {
			 if (resultado != null || v.getFecha().isBefore(resultado.getFecha())) {
				 resultado = v ;
			 }
		   }
	   }
	   
	  // Ternary operator:
		  // - If `resultado` is not null → return its flight code.
		  // - Else → return null (no matching flight found).

	return resultado != null ?resultado.getCodigo(): null ; 
	
   }

 // 7.	Dada una fecha f devuelve el conjunto de destinos diferentes de todos los vuelos de fecha f.
   
    @SuppressWarnings("unlikely-arg-type")
	public Set <String> getFechaDelDestino (LocalDate fecha){
    	
    	//HashSet garantiza que los elementos sean únicos (no repetidos).
    	
    	Set <String> destinos = new HashSet <>();
    	for (Vuelo v : getVuelos()) {
    		if (v.getFecha().equals(destinos)){
    			//i la fecha coincide, agregamos su destino al conjunto.
    			destinos.add(v.getDestino());
    		}
    	}
    	
    	return destinos;
    	
    	
    }
   

  // 8.	Dado un precio, ¿existe algún vuelo por debajo de ese precio?

   public Boolean getprecioMenor (double precio) {
	   for (Vuelo v : getVuelos()) {
		   if (v.getPrecio()<precio) {
			   return true ;
		   }
	   }
	   return false;
   }
   
   //9. ¿Están todos los vuelos por encima de un porcentaje de ocupación?
   
   public Boolean SiestanEncimaDelPorcenaje (double porcentaje) {
	   for (Vuelo v : getVuelos()) {
		   double ocupacion =(double)v.getNumPasajeros()/v.getNumPlazas()*100;
		   if (ocupacion<=porcentaje) {
			   return false;
		   }
	   } // si todos los vuelo por encima del porcentaje  
	   return true ;
   } 
   
   
  // 10.	¿Cuál es el vuelo con menor ocupación?
   
   public Vuelo getVueloconMenorOcupaacion (double ocupacion) {
	   Vuelo resultado = null ; 
	   //Se inicializa menorOcupacion con el valor más alto posible de tipo double.


	   double menorOcupacion = Double.MAX_VALUE;

	   for (Vuelo v : getVuelos()) {
		   double ocupacion1 = 100.0 * v.getNumPasajeros() / v.getNumPlazas();

		   if (ocupacion1 <menorOcupacion) {

			   //Actualizamos menorOcupacion con este nuevo valor más bajo.

           menorOcupacion = ocupacion;
           return resultado = v;

	   }
		   } return resultado;
   }
  // 11.	Dado un destino ¿Cuál es el vuelo más barato a ese destino?
 
   public Vuelo getVueoDestino (String destino) {
	     Vuelo resultado = null ; 
	    for (Vuelo v : getVuelos()) {
	    	if (v.getDestino().equals(destino)) {
	    		if (resultado == null || v.getPrecio()<resultado.getPrecio()) {
	    			resultado = v; 
	    		}
	    		}
	    	}
		return resultado;
	    }
   
   
   //13.	Dado un destino, devuelve una lista con los vuelos a ese destino ordenados por precio (ascendentemente).

  public List<Vuelo> getListVuelosOrdenadosPorprecio (String destino) {
	  List <Vuelo> resultado = new ArrayList <>();
	  for (Vuelo v : getVuelos ()) {
		  if(v.getDestino().equals(destino)) {
			  
			  //  add to list 
			  resultado.add(v);
		  }
	  }
	  // ordenar 
	  resultado.sort(Comparator.comparing(Vuelo::getPrecio));
	  return resultado;
	  
  }
  
//12.	Dada una fecha f devuelve el precio medio de los vuelos con salida posterior a f. Si no hubiera vuelos devuelve 0.0
  
 public double getPreciomedioDelLosVuelos (LocalDate fecha) {
	 
	 double suma = 0.0 ;
	 int contador = 0 ; 
	 for (Vuelo v : getVuelos()) {
		 if (v.getFecha().isAfter(fecha)) {
			 suma += v.getPrecio();
			 contador ++;
		 }
	 }
	 //no valid flights, so we return 0.0 to avoid division by zero.
	 
	 //condition ? valueIfTrue : valueIfFalse;

	return contador == 0? 0.0: suma/contador;
	 
	 
 }

  
}
