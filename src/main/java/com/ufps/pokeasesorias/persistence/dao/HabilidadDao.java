package com.ufps.pokeasesorias.persistence.dao;

import com.ufps.pokeasesorias.persistence.entity.Habilidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadDao extends CrudRepository<Habilidad, Long> {
}
