package com.ufps.pokeasesorias.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Estudiante extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @NonNull
    private String descripcion;
    @NonNull
    private Integer semestre;
    @NonNull
    private String codigo;
    @ManyToMany(mappedBy = "estudiantes", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "descripcion", "semestre", "codigo", "habilidades", "carrera", "mensajesEnviados", "mensajesRecibidos"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private List<Habilidad> habilidades;
    @ManyToOne
    @JoinColumn(name = "carrera")
    @JsonIgnoreProperties(value = {"nombre", "estudiantes"}, allowSetters = true)
    private Carrera carrera;
    @OneToMany(mappedBy = "receptor", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"descripcion", "remitente", "receptor", "fechaEnvio", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private List<Mensaje> mensajesEnviados;
    @OneToMany(mappedBy = "remitente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"descripcion", "remitente", "receptor", "fechaEnvio", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private List<Mensaje> mensajesRecibidos;
}
