package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Vuelo implements Comparable<Vuelo> {
	private String origen;
    private String destino;
    private double precio;
    private int numPasajeros;
    private int numPlazas;
    private String codigo;
    private LocalDate fecha;
    private Duration duracion;
    private List<String> tripulacion;
    
	public Vuelo(String origen, String destino, double precio, int numPasajeros, int numPlazas, String codigo,
			LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.numPasajeros = numPasajeros;
		this.numPlazas = numPlazas;
		this.codigo = codigo;
		this.fecha = fecha;
		this.duracion = duracion;
		this.tripulacion = tripulacion;
	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public double getPrecio() {
		return precio;
	}
	public int getNumPasajeros() {
		return numPasajeros;
	}
	public int getNumPlazas() {
		return numPlazas;
	}
	public String getCodigo() {
		return codigo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public List<String> getTripulacion() {
		return tripulacion;
	}
	

	
	@Override
    public int compareTo(Vuelo otro) {
        return this.fecha.compareTo(otro.fecha); // ordena por fecha
    }
	
	

}
