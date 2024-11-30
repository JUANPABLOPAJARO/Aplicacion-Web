package com.example.taller.Persistencia.Repositorios;


import com.example.taller.Persistencia.entitdades.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {

}
