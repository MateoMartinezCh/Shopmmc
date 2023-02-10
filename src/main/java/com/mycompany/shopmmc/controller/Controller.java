/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopmmc.controller;

import com.mycompany.shopmmc.model.Model;
import java.util.ArrayList;

/**
 *
 * @author freit
 * @param <T>
 */
public abstract class Controller {
    
    public abstract Model crear();
    public abstract ArrayList<Model> listar();
    public abstract void eliminar();
    public abstract Model editar();
}
