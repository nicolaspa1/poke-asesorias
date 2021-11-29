package com.ufps.pokeasesorias.domain.service;

import com.ufps.pokeasesorias.persistence.dao.UsuarioDao;
import com.ufps.pokeasesorias.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario) {
        usuario.setContrasena(DigestUtils.md5DigestAsHex(usuario.getContrasena().getBytes()));
        return usuarioDao.save(usuario);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        usuarioDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Usuario findByAlias(String alias) {
        return usuarioDao.findByAlias(alias);
    }

    @Override
    public UserDetails loadUserByUsername(String alias) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByAlias(alias);
        List<GrantedAuthority> roles = new ArrayList<>();
        //roles.add(new SimpleGrantedAuthority(usuario.getRol().toString()));
        return new User(usuario.getAlias(), "{noop}" + usuario.getContrasena(), roles);
    }
}
