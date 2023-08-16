package com.unicomer.homebanking.servicios;

import com.unicomer.homebanking.entidades.CuentaBancaria;
import com.unicomer.homebanking.entidades.Usuario;
import com.unicomer.homebanking.excepciones.MiException;
import com.unicomer.homebanking.repositorios.CuentaBancariaRepositorio;
import com.unicomer.homebanking.repositorios.UsuarioRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaBancariaServicio {
    
    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void crearCuentaBancaria(String idUsuario) throws MiException {
        
        if(idUsuario.isEmpty() || idUsuario == null)
            throw new MiException("El ID del usuario no puede ser nulo");
        
        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        
        cuentaBancaria.setUsuario(usuario);
        
        cuentaBancariaRepositorio.save(cuentaBancaria);
    }
    
    @Transactional
    public void depositar(String idCuenta, Double monto) throws MiException {
        validarMonto(monto);
        
        Optional<CuentaBancaria> respuesta = cuentaBancariaRepositorio.findById(idCuenta);
        
        if(respuesta.isPresent()) {
            CuentaBancaria cuentaBancaria = respuesta.get();
            cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() + monto);
            cuentaBancariaRepositorio.save(cuentaBancaria);
        }
    }
    
    @Transactional
    public void extraer(String idCuenta, Double monto) throws MiException {
        validarMonto(monto);
        
        Optional<CuentaBancaria> respuesta = cuentaBancariaRepositorio.findById(idCuenta);
        
        if(respuesta.isPresent()) {
            CuentaBancaria cuentaBancaria = respuesta.get();
            cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - monto);
            cuentaBancariaRepositorio.save(cuentaBancaria);
        }
    }
    
    @Transactional
    public void transferir(String idCuenta, Double monto, String idATransferir) throws MiException {
        validarMonto(monto);
        
        Optional<CuentaBancaria> respuesta = cuentaBancariaRepositorio.findById(idCuenta);
        Optional<CuentaBancaria> respuesta2 = cuentaBancariaRepositorio.findById(idATransferir);
        
        if(respuesta.isPresent() && respuesta2.isPresent()) {
            CuentaBancaria cuentaBancaria = respuesta.get();
            cuentaBancaria.setSaldo(cuentaBancaria.getSaldo() - monto);
            cuentaBancariaRepositorio.save(cuentaBancaria);
            
            CuentaBancaria cuentaATransferir = respuesta2.get();
            cuentaATransferir.setSaldo(cuentaATransferir.getSaldo() + monto);
            cuentaBancariaRepositorio.save(cuentaATransferir);
        }
    }
    
    public void validarMonto(Double monto) throws MiException {
        if(monto <= 0)
            throw new MiException("El monto no puede ser igual o menor a 0");
    }
}
