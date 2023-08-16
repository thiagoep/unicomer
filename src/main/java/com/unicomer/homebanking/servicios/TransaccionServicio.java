package com.unicomer.homebanking.servicios;

import com.unicomer.homebanking.entidades.Transaccion;
import com.unicomer.homebanking.enums.TipoTransaccion;
import com.unicomer.homebanking.excepciones.MiException;
import com.unicomer.homebanking.repositorios.CuentaBancariaRepositorio;
import com.unicomer.homebanking.repositorios.TransaccionRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransaccionServicio {
    
    @Autowired
    private TransaccionRepositorio transaccionRepositorio;
    
    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;
    
    @Autowired
    private CuentaBancariaServicio cuentaBancariaServicio;
    
    @Transactional
    public void crearTransaccion(TipoTransaccion tipoTransaccion, String idCuentaBancaria, Double monto) throws MiException {
        if(monto <= 0)
            throw new MiException("Especifique un monto válido");
        
        Transaccion transaccion = new Transaccion();
        
        transaccion.setCuenta(cuentaBancariaRepositorio.findById(idCuentaBancaria).get());
        transaccion.setFecha(new Date());
        transaccion.setMonto(monto);
        transaccion.setTipo(tipoTransaccion);
        
        if(tipoTransaccion.equals(tipoTransaccion.DEPOSITO))
            cuentaBancariaServicio.depositar(idCuentaBancaria, monto);
        else if(tipoTransaccion.equals(tipoTransaccion.EXTRACCION))
            cuentaBancariaServicio.extraer(idCuentaBancaria, monto);
        else
            cuentaBancariaServicio.depositar(idCuentaBancaria, monto);
        
        transaccionRepositorio.save(transaccion);
    }
    
    public List<Transaccion> listarTransacciones() {
        List<Transaccion> transacciones = new ArrayList();
        
        transacciones = transaccionRepositorio.findAll();
        
        return transacciones;
    }
}
