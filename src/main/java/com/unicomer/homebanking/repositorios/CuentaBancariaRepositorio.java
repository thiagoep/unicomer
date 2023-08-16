package com.unicomer.homebanking.repositorios;

import com.unicomer.homebanking.entidades.CuentaBancaria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepositorio extends JpaRepository<CuentaBancaria, String> {
    
    @Query("SELECT c FROM CuentaBancaria c WHERE c.usuario.nombre = :nombre")
    public List<CuentaBancaria> buscarPorUsuario(@Param("nombre") String nombre);
}
