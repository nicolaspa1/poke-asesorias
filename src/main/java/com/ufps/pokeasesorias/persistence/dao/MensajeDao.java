package com.ufps.pokeasesorias.persistence.dao;

import com.ufps.pokeasesorias.persistence.entity.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeDao extends CrudRepository<Mensaje, Long> {
}
