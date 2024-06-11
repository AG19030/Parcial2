/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.controladores;

import com.mycompany.appweb.entidades.Alumno;
import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.appweb.entidades.Materia;
import java.time.LocalDate;

/**
 *
 * @author krlos
 */
@Named
@RequestScoped
public class InscripcionController {

    List<Inscripcion> inscripcionesList = new ArrayList<>();

    Inscripcion inscripcion = new Inscripcion();
    Alumno alumnoSeleccionado = new Alumno();
    Materia materiaSeleccionada = new Materia();
    @EJB
    DataService servicio;

    @PostConstruct
    public void cargarInscripciones() {
        inscripcionesList = servicio.getInscripciones();
    }

    public void guardarInscripcion() {

       
        inscripcion.setAlumno(alumnoSeleccionado);
        inscripcion.setMateria(materiaSeleccionada);
        inscripcion.setFechaInscripcion(LocalDate.now());
        servicio.saveInscripcion(inscripcion);
        inscripcion = new Inscripcion();
        cargarInscripciones();
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }

    //-------------Getters y Setters-------------------
    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public Materia getMateriaSeleccionada() {
        return materiaSeleccionada;
    }

    public void setMateriaSeleccionada(Materia materiaSeleccionada) {
        this.materiaSeleccionada = materiaSeleccionada;
    }

    public DataService getServicio() {
        return servicio;
    }

    public void setServicio(DataService servicio) {
        this.servicio = servicio;
    }
}
