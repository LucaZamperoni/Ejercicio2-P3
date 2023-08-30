package com.example.ej2.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;

    // Anotación que establece una relación uno a uno entre la entidad actual y otra entidad relacionada (Domicilio).
    // El atributo "cascade" indica que las operaciones en la entidad actual también se propagarán a la entidad relacionada.
    // En este caso, "CascadeType.ALL" indica que las operaciones de cascada (crear, actualizar, eliminar) se aplicarán a la entidad relacionada.
    // El atributo "orphanRemoval" permite que los registros de la entidad relacionada se eliminen automáticamente si se eliminan de esta entidad.
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)

    // Anotación que especifica que esta entidad tendrá una columna llamada "domicilioId" como clave foránea (FK).
    // Esta columna se utilizará para establecer la relación uno a uno con la entidad Domicilio.
    // Se establece el nombre de la columna en la base de datos donde se almacenará la clave foránea.
    // Esta anotación define que la entidad actual mantendrá la relación con la entidad Domicilio mediante una clave foránea.
    @JoinColumn(name = "domicilioId")
    private Domicilio domicilio;
}
