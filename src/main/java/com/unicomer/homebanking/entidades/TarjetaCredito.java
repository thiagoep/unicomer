package com.unicomer.homebanking.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class TarjetaCredito {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String numeroDeTarjeta;
    
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    private Double limiteCredito;
    
    @ManyToOne
    private CuentaBancaria cuentaBancaria;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String numeroDeTarjeta, Date fechaVencimiento, Double limiteCredito, CuentaBancaria cuentaBancaria) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.limiteCredito = limiteCredito;
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuenta) {
        this.cuentaBancaria = cuenta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
}
