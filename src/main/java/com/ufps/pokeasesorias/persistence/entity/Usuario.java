package com.ufps.pokeasesorias.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    @Column(unique = true)
    private String alias;
    @NonNull
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
