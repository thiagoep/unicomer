package com.unicomer.homebanking.entidades;

import com.unicomer.homebanking.enums.TipoDocumento;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
        
    private String email;
    
    private String contrasena;
    
    private TipoDocumento tipoDocumento;
    
    private Integer documento;
    
    private Double sueldoBruto;
    
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasena, Date fechaDeNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    
    
}
