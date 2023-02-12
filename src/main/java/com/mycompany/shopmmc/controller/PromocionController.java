/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopmmc.controller;

import com.mycompany.shopmmc.model.Promocion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class PromocionController extends AbstractController<Promocion> {

    @Inject
    TiendaController tiendacontroller;

    public PromocionController() {
        super(Promocion::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("25% De descuento");
        this.getSelected().setDescripcion("Descuento de inauguración");
        this.getSelected().setFechainicio("10 de febrero del 2023");
        this.getSelected().setFechafin("16 de febrero del 2023");
        
        this.add();
                
        this.create();
        this.getSelected().setNombre("10% De descuento");
        this.getSelected().setDescripcion("Oferta de fin de año");
        this.getSelected().setFechainicio("10 de diciembre del 2023");
        this.getSelected().setFechafin("31 de diciembre del 2023");
        
        this.add();
        
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-2);
        this.getSelected().setNombre("50% De descuento");
        this.getSelected().setDescripcion("Descuento de liquidación");
        this.getSelected().setFechainicio("19 de febrero del 2023");
        this.getSelected().setFechafin("30 de febrero del 2023");

        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
        this.getSelected().setNombre("15% De descuento");
        this.getSelected().setDescripcion("Descuento para Jóvenes");
        this.getSelected().setFechainicio("1 de enero del 2023");
        this.getSelected().setFechafin("31 de diciembre del 2023");

        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            if (this.tiendacontroller.getItems().stream().filter(item -> {
                return item.getPromocion() == this.getSelected();
            }).count() == 0) {
                this.repositorio.remove(this.getSelected());
                return "remove";
            } else {
                return "";
            }

        }
        //se tiene que poner el error
        return "";

    }

    @Override
    public String preEdit() {

        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());
            //si ya existe

        }
        return "sucess";
    }
}
