package com.example.ej2;

import com.example.ej2.entidades.Domicilio;
import com.example.ej2.entidades.Persona;
import com.example.ej2.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ej2Application {

	@Autowired
	PersonaRepositorio personaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(Ej2Application.class, args);
	}
	@Bean
	CommandLineRunner init(PersonaRepositorio personaRepositorio) {
		return args -> {
			Persona persona = Persona.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.edad(30)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Perito Moreno")
					.numero(30)
					.build();

			persona.setDomicilio(domicilio);

			personaRepositorio.save(persona);

			Persona personaRecuperada = personaRepositorio.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				System.out.println("Calle : " + personaRecuperada.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada.getDomicilio().getNumero());
			}
		};
	}
}
