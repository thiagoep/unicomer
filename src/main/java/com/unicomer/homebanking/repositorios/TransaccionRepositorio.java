package com.unicomer.homebanking.repositorios;

import com.unicomer.homebanking.entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer> {

}
