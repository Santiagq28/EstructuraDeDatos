
package com.mycompany.listasimple;

import javax.swing.JOptionPane;

public class ListaSimple {
    
    Nodo inicio;
    ListaSimple(){
        inicio=null;
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
        while (temporal != null && 
              !(temporal.getNombre().equals(datoBuscado) || 
                Integer.toString(temporal.getEdad()).equals(datoBuscado) || 
                Float.toString(temporal.getPromedio()).equals(datoBuscado))) {
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
                temporal = temporal.getEnlace();
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
    
    public void eliminar(int indice){
        int posicion = 0;
        boolean indiceEncontrado = false;
        
        Nodo anterior = inicio;
        Nodo siguiente = null;
        
        if(indice == 0){
            inicio = inicio.getEnlace();
            return;
        }
        
        while(anterior != null){
            if(posicion+1==indice){
                siguiente = anterior.getEnlace().getEnlace();
                indiceEncontrado = true;
                break;
            }
            
        }
    }
}
