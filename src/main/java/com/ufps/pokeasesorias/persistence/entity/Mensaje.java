package com.ufps.pokeasesorias.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "remitente")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "descripcion", "semestre", "codigo", "habilidades", "carrera", "mensajesEnviados", "mensajesRecibidos"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Estudiante remitente;
    @ManyToOne
    @JoinColumn(name = "receptor")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "descripcion", "semestre", "codigo", "habilidades", "carrera", "mensajesEnviados", "mensajesRecibidos"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Estudiante receptor;
    @NonNull
    private Date fechaEnvio;
    @OneToOne(mappedBy = "mensajeSiguiente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Respuesta respuestaAnterior;
    @OneToOne(mappedBy = "mensajeSiguiente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Respuesta respuestaSiguiente;
}
