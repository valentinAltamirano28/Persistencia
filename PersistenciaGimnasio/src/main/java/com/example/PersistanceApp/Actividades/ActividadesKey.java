package com.example.PersistanceApp.Actividades;

import com.example.PersistanceApp.CentrosDeportivos.CentrosDeportivos;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class ActividadesKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "centros_deportivos_rut")
    private CentrosDeportivos centrosDeportivos;


    @Column(name = "nombre", updatable = false)
    private String nombre;


    @Column(name = "horario",nullable = false )
    private String horario;


    @Column(name = "fecha", nullable = false)
    private String fecha;


    public ActividadesKey() {
    }

    public ActividadesKey(CentrosDeportivos centrosDeportivos, String nombre, String horario, String fecha) {
        this.centrosDeportivos = centrosDeportivos;
        this.nombre = nombre;
        this.horario = horario;
        this.fecha = fecha;
    }

    public CentrosDeportivos getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentrosDeportivos centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ActividadesKey{" +
                "centrosDeportivos=" + centrosDeportivos +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
