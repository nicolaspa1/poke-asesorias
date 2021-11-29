package com.ufps.pokeasesorias.persistence.dao;

import com.ufps.pokeasesorias.persistence.entity.Respuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaDao extends CrudRepository<Respuesta, Long> {
}
