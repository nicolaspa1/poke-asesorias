package com.ufps.pokeasesorias.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "mensajeAnterior", unique = true)
    @JsonIgnoreProperties(value = {"descripcion", "remitente", "receptor", "fechaEnvio", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Mensaje mensajeAnterior;
    @OneToOne
    @JoinColumn(name = "mensajeSiguiente", unique = true)
    @JsonIgnoreProperties(value = {"descripcion", "remitente", "receptor", "fechaEnvio", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Mensaje mensajeSiguiente;
}
