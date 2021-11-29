package com.ufps.pokeasesorias.domain.service;

import com.ufps.pokeasesorias.persistence.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UsuarioServiceImplTest {
    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioServiceInterface usuarioService;

    @Test
    public void crearUsuarioTest() {
        Usuario usuario = new Usuario();
        String alias = "alias10";
        usuario.setAlias(alias);
        usuario.setContrasena("contrasena1");
        Usuario retorno = usuarioService.save(usuario);
        assertEquals(usuario.getContrasena(), retorno.getContrasena());
        usuarioService.deleteById(usuario.getId());
        assertNull(usuarioService.findByAlias(alias));
    }
}