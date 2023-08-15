package com.unicomer.homebanking.servicios;

import com.unicomer.homebanking.entidades.CuentaBancaria;
import com.unicomer.homebanking.entidades.Usuario;
import com.unicomer.homebanking.repositorios.CuentaBancariaRepositorio;
import com.unicomer.homebanking.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaServicio {
    
    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public void crearCuentaBancaria(String idUsuario) {
        
        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        
        cuentaBancaria.setUsuario(usuario);
        
        cuentaBancariaRepositorio.save(cuentaBancaria);
    }
}
