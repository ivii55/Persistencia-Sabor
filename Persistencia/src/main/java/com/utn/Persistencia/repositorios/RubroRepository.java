package com.utn.Persistencia.repositorios;

import com.utn.Persistencia.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository <Rubro, Long> {
}
