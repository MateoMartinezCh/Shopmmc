/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopmmc.controller;

import com.mycompany.shopmmc.model.Categoria;
import com.mycompany.shopmmc.model.Promocion;
import com.mycompany.shopmmc.model.Tienda;
import com.mycompany.shopmmc.views.SearchView;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class TiendaController extends AbstractController<Tienda> {

    @Inject
    private PromocionController promocionController;
    @Inject
    private CategoriaController categoriaController;
    //@Inject
    //private SearchView searchView;
    public TiendaController() {
        super(Tienda::new);
        //this.load();
    }

    @Override
    public Tienda getSelected() {
        return super.getSelected();
    }
 /*    public List<Tienda> getItemsPorCategoria() {
        List<Tienda> tiendas = this.repositorio.getAll();
        List<Tienda> tiendasalistar = new ArrayList<Tienda>();
        tiendas.forEach(tienda -> tienda.getCategoria().getNombre());
        return t;
    }*/
    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Tieda De Rojales");
        this.getSelected().setDireccion("Calle Juan Nº1");
        this.getSelected().setDescripcion("La mejor tienda de rojales");
        this.getSelected().setCoordenadas("38.08702047762007, -0.7248397994436843");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        this.getSelected().setNombre("Tienda de Almoradí");
        this.getSelected().setDireccion("Calle romero Nº4");
        this.getSelected().setDescripcion("La mejor tienda de almoradí");
        this.getSelected().setCoordenadas("38.10929279294716, -0.7915971848083962");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
        this.getSelected().setNombre("Tienda de Guardamar");
        this.getSelected().setDireccion("Calle Costa Nº8");
        this.getSelected().setDescripcion("La mejor tienda de guardamar");
        this.getSelected().setCoordenadas("38.088517285869564, -0.6466562867995801");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            if (this.getSelected().getCategoria().getNombre() == null) {
                this.repositorio.remove(this.getSelected());
                return "remove";
            }
            return "failure";
        } else {
            return "";
        }

    }
    
    @Override
    public String preEdit() {
        return "edit";
    }

    public void selectedChange(ValueChangeEvent event) {
        this.setSelected((Tienda) event.getNewValue());
    }

    public Tienda getTiendaById(int id) {
        Tienda p = null;
        Optional<Tienda> element = this.getItems().stream().filter(item -> {
            return item.getId() == id;
        }).findFirst();
        if (!element.isEmpty()) {
            p = element.get();
        }
        return p;
    }

    /*public void removeImage(Imagen img){
       this.getSelected().removeImagen(img);
    }*/
    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected() != null) {
            if (this.getSelected().getId() == -1) {
                this.getSelected().setId(this.repositorio.getAll().size() + 1);
                this.repositorio.create(this.getSelected());
            } else {

                this.repositorio.update(this.getSelected());
            }
        }
        return "sucess";
    }
}
