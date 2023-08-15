package com.unicomer.homebanking.repositorios;

import com.unicomer.homebanking.entidades.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaCreditoRepositorio extends JpaRepository<TarjetaCredito, String> {
    
}
