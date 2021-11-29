package com.ufps.pokeasesorias.domain.service;

import com.ufps.pokeasesorias.persistence.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServiceInterface extends CrudServiceInterface<Usuario, Long>, UserDetailsService {
    public Usuario findByAlias(String alias);
}
