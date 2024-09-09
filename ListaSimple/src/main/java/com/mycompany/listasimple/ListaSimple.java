/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listasimple;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-27
 */
public class ListaSimple {
    
    Nodo inicio;
    int size;
    ListaSimple(){
        inicio=null;
        size = 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    public void insertarInicio(String nombre, int edad, float promedio){
        
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            inicio = nuevo;
        }else{
            nuevo.setEnlace(inicio);
            inicio = nuevo;
        }
    }
    
    public void insertarFinal(String nombre, int edad, float promedio){
        
        Nodo nuevo = new Nodo();
        
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);
        nuevo.setEnlace(null);
        
        if(inicio == null){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            inicio = nuevo;
        }
        else{
            Nodo temporal = inicio;
            while(temporal.getEnlace() != null){
                temporal = temporal.getEnlace();
            }
            temporal.setEnlace(nuevo);
        }   
    }
    
    //Agregar un nodo por posición adelante de uno dado
    public void insertarEnPosicion(String nombre, int edad, float promedio, int posicion) {
    Nodo nuevo = new Nodo();
    nuevo.setNombre(nombre);
    nuevo.setEdad(edad);
    nuevo.setPromedio(promedio);

    if (posicion == 0) {
        nuevo.setEnlace(inicio);
        inicio = nuevo;
    } else {
            Nodo temporal = inicio;
            int contador = 0;
            while (temporal != null && contador < posicion - 1) {
                temporal = temporal.getEnlace();
                contador++;
            }
            if (temporal != null) {
                nuevo.setEnlace(temporal.getEnlace());
                temporal.setEnlace(nuevo);
            } else {
                JOptionPane.showMessageDialog(null, "La posición especificada no existe.");
            }
        }
    }
    
    //Agregar un nodo por dato delante de uno dado
    
    public void insertarDespuesDeDato(String nombre, int edad, float promedio, String datoBuscado) {
        Nodo nuevo = new Nodo();
        nuevo.setNombre(nombre);
        nuevo.setEdad(edad);
        nuevo.setPromedio(promedio);

        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }

        Nodo temporal = inicio;
        while (temporal != null && !temporal.getNombre().equals(datoBuscado)) {
            temporal = temporal.getEnlace();
        }

        if (temporal != null) {
            nuevo.setEnlace(temporal.getEnlace());
            temporal.setEnlace(nuevo);
        } else {
            JOptionPane.showMessageDialog(null, "El dato buscado no se encuentra en la lista.");
        }
    }
    
    
    public void consultar(){
        Nodo temporal = inicio;
        if(inicio == null){
           JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
        while (temporal != null) { 
            JOptionPane.showMessageDialog(null, "Nombre: " + temporal.getNombre() + " Edad: " + temporal.getEdad() + " Promedio: " + temporal.getPromedio());
            temporal = temporal.getEnlace(); // Avanzamos al siguiente nodo
        }
        }
        
    }
    public void obtener(int index){
        int contador = 0;
        Nodo temporal = inicio;
        while(contador<index){
            temporal = temporal.getEnlace();
            contador++;
        }
        JOptionPane.showMessageDialog(null,"Nombre: " +temporal.getNombre() + " Edad:"+ temporal.getEdad() +" Promedio:" +temporal.getPromedio());
    }
}
