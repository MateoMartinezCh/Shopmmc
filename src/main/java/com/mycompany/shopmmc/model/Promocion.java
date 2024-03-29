/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopmmc.model;

/**
 *
 * @author Pedro
 */
public class Promocion implements Comparable<Promocion>, Cloneable {

    private String nombre;
    private String descripcion;
    private String fechainicio;
    private String fechafin;
    private boolean activo;
    private int id;

    public Promocion() {
        this.id = -1;
        //this.fechainicio = "10 del 02 del 2023";
        //this.fechafin = "15 del 02 del 2023";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechainicio
     */
    public String getFechainicio() {
        return fechainicio;
    }

    /**
     * @param fechainicio the fechainicio to set
     */
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * @return the fechafin
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    @Override
    public int compareTo(Promocion o) {
        if (o == null) {
            return -1;
        } else {
            if (o.getId() == this.id) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    protected Object clone() {
        Promocion l = new Promocion();
        l.activo = this.activo;
        l.id = this.id;
        l.nombre = this.nombre;
        return l;
    }
}