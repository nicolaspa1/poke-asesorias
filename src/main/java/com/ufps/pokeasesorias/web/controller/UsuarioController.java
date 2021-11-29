package com.ufps.pokeasesorias.web.controller;

import com.ufps.pokeasesorias.domain.dto.AuthenticationRequest;
import com.ufps.pokeasesorias.domain.service.UsuarioServiceInterface;
import com.ufps.pokeasesorias.persistence.entity.Usuario;
import com.ufps.pokeasesorias.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioServiceInterface usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Map<String, Object> response = new HashMap<>();
        Usuario prueba = usuarioService.findByAlias(usuario.getAlias());
        if (prueba == null) {
            usuarioService.save(usuario);
            response.put("mensaje", "usuario creado correctamente");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "el alias del usuario: " + usuario.getAlias() + " no esta disponible");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody AuthenticationRequest request) {
        try {
            request.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
            System.out.println(request);
            System.out.println(usuarioService.findByAlias(request.getUsername()));
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = usuarioService.loadUserByUsername(request.getUsername());
            System.out.println(request);
            System.out.println(userDetails);
            Map<String, Object> response = new HashMap<>();
            response.put("jwt", jwtUtil.generateToken(userDetails));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
