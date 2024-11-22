package com.gabriellibano.greenenergy.greenenergy.repository;

import com.gabriellibano.greenenergy.greenenergy.model.Dispositivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DispositivosRepository extends JpaRepository<Dispositivos, Long>{
    <T> T findByNome(String nome);
}
