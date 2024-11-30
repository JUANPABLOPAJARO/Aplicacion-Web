package com.example.taller.Servicio;

import com.example.taller.Persistencia.Repositorios.ConductorRepository;
import com.example.taller.Persistencia.entitdades.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    public Conductor guardar(Conductor conductor) {
        conductorRepository.save(conductor);
        return conductor;
    }

    public List<Conductor> findAll() {
        return conductorRepository.findAll();



    }

    
    public Conductor actualizar(Long id) {
        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado con id: " + id));
        conductor.setEstado(false);
        return conductorRepository.save(conductor);
    }
}






