package fp.vuelos;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Vuelos {

    private final String nombre;
    private final List<Vuelo> vuelos;

    public Vuelos(String nombre, List<Vuelo> vuelos,String origen, String destino, double precio, int numPasajeros, int numPlazas, String codigo,
			LocalDate fecha, Duration duracion, List<String> tripulacion) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>(vuelos);
    }

    // toString: representa todos los vuelos separados por salto de línea
    @Override
    public String toString() {
        return vuelos.stream()
                     .map(Vuelo::toString)
                     .collect(Collectors.joining("\n"));
    }

    // Consultables
    public String getNombre() {
        return nombre;
    }

    public List<Vuelo> getVuelos() {
        return new ArrayList<>(vuelos);
    }

    public Integer getNumero() {
        return vuelos.size();
    }

    public Integer getPasajeros() {
        return vuelos.stream().mapToInt(Vuelo::getNumPasajeros).sum();
    }

    public OptionalDouble getPrecioMedio() {
        return vuelos.stream().mapToDouble(Vuelo::getPrecio).average();
    }

    public int getNumeroDestinos() {
        return (int) vuelos.stream()
                           .map(Vuelo::getDestino)
                           .distinct()
                           .count();
    }

    public int getPasajeroDestino(String destino) {
        return vuelos.stream()
                     .filter(v -> v.getDestino().equals(destino))
                     .mapToInt(Vuelo::getNumPasajeros)
                     .sum();
    }

    // Operaciones
    public void incorporaVuelo(Vuelo v) {
        vuelos.add(v);
    }

    public void incorporaVuelos(Collection<Vuelo> nuevosVuelos) {
        vuelos.addAll(nuevosVuelos);
    }

    public void eliminaVuelo(Vuelo v) {
        vuelos.remove(v);
    }

    public void ordena() {
        vuelos.sort(Comparator.naturalOrder());
    }

    public boolean existeVueloDestino(String destino) {
        return vuelos.stream().anyMatch(v -> v.getDestino().equals(destino));
    }

    // Criterio de igualdad
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vuelos)) return false;
        Vuelos otros = (Vuelos) o;
        return Objects.equals(nombre, otros.nombre) &&
               Objects.equals(vuelos, otros.vuelos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, vuelos);
    }
}
