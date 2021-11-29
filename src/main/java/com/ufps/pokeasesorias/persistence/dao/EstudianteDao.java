package com.ufps.pokeasesorias.persistence.dao;

import com.ufps.pokeasesorias.persistence.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteDao extends CrudRepository<Estudiante, Long> {
}
