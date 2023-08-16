package com.unicomer.homebanking.servicios;

import com.unicomer.homebanking.entidades.CuentaBancaria;
import com.unicomer.homebanking.entidades.TarjetaCredito;
import com.unicomer.homebanking.repositorios.CuentaBancariaRepositorio;
import com.unicomer.homebanking.repositorios.TarjetaCreditoRepositorio;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarjetaCreditoServicio {
    
    @Autowired
    private TarjetaCreditoRepositorio tarjetaCreditoRepositorio;
    
    @Autowired
    private CuentaBancariaRepositorio cuentaBancariaRepositorio;
    
    @Transactional
    public void solicitarTarjetaCredito(String idCuentaBancaria) {
        
        CuentaBancaria cuentaBancaria = cuentaBancariaRepositorio.findById(idCuentaBancaria).get();
        TarjetaCredito tarjetaCredito = new TarjetaCredito();
        Calendar fechaActual = Calendar.getInstance();
        
        tarjetaCredito.setLimiteCredito(tarjetaCredito.getCuentaBancaria().getUsuario().getSueldoBruto() / 2);
        
        tarjetaCredito.setNumeroDeTarjeta(crearNumeroTarjeta(16));
        
        fechaActual.add(Calendar.DAY_OF_YEAR, 365);
        
        tarjetaCredito.setFechaVencimiento(fechaActual.getTime());
        
        tarjetaCreditoRepositorio.save(tarjetaCredito);
    }
    
    public List<TarjetaCredito> listarTarjetas() {
        List<TarjetaCredito> tarjetas = new ArrayList();
        
        tarjetas = tarjetaCreditoRepositorio.findAll();
        
        return tarjetas;
    }
    
    public String crearNumeroTarjeta(int cantNumeros) {
        int nro;
        Random random = new Random();
        StringBuilder nroTarjeta = new StringBuilder();
        
        for (int i = 0; i < cantNumeros; i++) {
            nro = random.nextInt(10);
            nroTarjeta.append(nro);
        }
        
        return nroTarjeta.toString();
    }
}
