    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.Objects;

/**
 *
 * @author krlos
 */
@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Integer id;
    
     @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia materia;
    
    
    @Column(name = "ciclo")
    private Integer ciclo;
    
    @Column(name = "anio")
    private String anio;
    
    @Column(name = "fechaInscripcion")
    private LocalDate fechaInscripcion;
    
    
    
  
    
    
    //-------------------------Getters & Setters-------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

   

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion.toString();
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    //-------------------------Equals & Hashcode-------------------------

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }
    
    //-------------------------toString-------------------------

    //-------------------------Constructores-------------------------

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, Integer ciclo, String anio, LocalDate fechaInscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechaInscripcion = fechaInscripcion;
    }

    

    public Inscripcion() {
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    
    
}
