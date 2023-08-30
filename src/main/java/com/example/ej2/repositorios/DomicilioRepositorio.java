package com.example.ej2.repositorios;

import com.example.ej2.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio, Long> {
}
