package com.ufps.pokeasesorias.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Carrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "descripcion", "semestre", "codigo", "habilidades", "carrera", "mensajesEnviados", "mensajesRecibidos"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private List<Estudiante> estudiantes;
}