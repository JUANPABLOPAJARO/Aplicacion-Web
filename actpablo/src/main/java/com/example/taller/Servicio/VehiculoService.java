package com.example.taller.Servicio;

import com.example.taller.Persistencia.Repositorios.ConductorRepository;
import com.example.taller.Persistencia.Repositorios.VehiculoRepository;
import com.example.taller.Persistencia.entitdades.Conductor;
import com.example.taller.Persistencia.entitdades.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private ConductorRepository conductorRepository;
    public Vehiculo asignarConductor(Long vehiculoId, Long conductorId) {
        // Buscar el vehículo
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + vehiculoId));


        if (vehiculo.getConductor() != null) {
            throw new RuntimeException("El vehículo ya tiene un conductor asignado.");
        }


        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con ID: " + conductorId));


        vehiculo.setConductor(conductor);
        System.out.println(vehiculo);
        System.out.println(conductor);
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return vehiculo;
    }

    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();

    }
    public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculoActualizado) {

        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + id));

        vehiculo.setPlaca(vehiculoActualizado.getPlaca());
        vehiculo.setEstado(vehiculoActualizado.isEstado());
        vehiculo.setTipo(vehiculoActualizado.getTipo());
        vehiculo.setConductor(vehiculoActualizado.getConductor());

        // Guarda los cambios en la base de datos
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizar(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado con id: " + id));
        vehiculo.setEstado(false);
        return vehiculoRepository.save(vehiculo);
    }
}
