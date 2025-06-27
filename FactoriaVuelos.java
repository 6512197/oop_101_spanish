package fp.vuelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoriaVuelos {

    // Lee un archivo línea por línea y parsea cada línea como un Vuelo
    public static List<Vuelo> leeVuelos(String nomfich) throws IOException { 
    	//creating an empty, resizable, mutable list
    	List<Vuelo> lista = new ArrayList<>();
    	/*try (BufferedReader br = new BufferedReader(new FileReader(nomfich))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(parseaVuelo(linea));
            }
        }
        */
    	try (BufferedReader br = new BufferedReader(new FileReader(nomfich))) {
    	    String linea;
    	    boolean isFirst = true;
    	    while ((linea = br.readLine()) != null) {
    	        if (isFirst) {
    	            isFirst = false; // skip header
    	            continue;
    	        }
    	        lista.add(parseaVuelo(linea));
    	    }
    	}
    	return lista;
    }
    
    // con el metodo buffer  y stream 
    
   /* public static List<Vuelo> leeVuelos(String nomfich) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomfich))) {
            return br.lines()
                     .map(FactoriaVuelos::parseaVuelo)
                     .collect(Collectors.toList());
        }
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomfich))) {
        return br.lines()
             .skip(1) // skip the header
             .map(FactoriaVuelos::parseaVuelo)
             .collect(Collectors.toList());
}
    }*/


    // Convierte una línea de datos de vuelo en un objeto Vuelo
    public static Vuelo parseaVuelo(String datosVuelo) { 
    	String[]partes = datosVuelo.split(";");
    	String origen = partes[0];
    	String destino = partes[1];
        double precio = Double.parseDouble(partes[2]);
        int numPasajeros = Integer.parseInt(partes[3]);
        int numPlazas = Integer.parseInt(partes[4]);
        String codigo = partes[5];
        LocalDate fecha = parseaFecha(partes[6]);
        Duration duracion = parseaDuracion(partes[7]);
        List<String> tripulacion = parseaTripulacion(partes[8]);
		return new Vuelo(origen, destino, precio, numPasajeros, numPlazas, codigo, fecha, duracion, tripulacion);
        
    }

    // Dada una cadena con tripulantes separados por coma, devuelve una lista de strings
    public static List<String> parseaTripulacion(String datos) {
    	//cannot add or remove elements 
    	return Arrays.asList(datos.split(","));
    }

    // Convierte una cadena "dd/mm/yyyy" en un objeto LocalDate
    public static LocalDate parseaFecha(String fecha) {
    	String[]partes= fecha.split("/");
    	return LocalDate.of(Integer.parseInt(partes[2]), Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
    }

    // Convierte un número de minutos (como string) en un objeto Duration
    public static Duration parseaDuracion(String minutos) {
    	return Duration.ofMinutes(Long.parseLong(minutos));
    }
}

