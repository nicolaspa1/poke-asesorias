package com.ufps.pokeasesorias.persistence.dao;

import com.ufps.pokeasesorias.persistence.entity.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraDao extends CrudRepository<Carrera, Long> {
}
