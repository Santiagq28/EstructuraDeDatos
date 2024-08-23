/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-27
 */
public class Menu {
    
    String platos[];
    int datos[][];
    String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    
    public void crearMenu(int cantidad){
        platos = new String[cantidad];
        int i = 0;
        while(i<cantidad){
            platos[i]=JOptionPane.showInputDialog("Diga el nombre del plato "+(i+1));
            i++;
        }
    }
    public void consultarMenu(){
        String list_platos = "";
        for(int i = 0; i<platos.length;i++){
            list_platos += platos[i]+"\n";
            
        }
        JOptionPane.showMessageDialog(null, "Platos: \n"+list_platos);
        
                
    }
    public void ingresarDatos(){
        datos = new int[6][platos.length];
        
        for(int f = 0;f<6;f++){
            for(int c = 0;c<platos.length;c++){
                datos[f][c]=Integer.parseInt(JOptionPane.showInputDialog(null, "Ventas para el día "+dias[f]+" plato: "+platos[c]));
            }
        }
    }
    public void mostrarDatos(){
        String table = "";
        for(int f = 0;f<6;f++){
            table += dias[f]+": ";
            for(int c = 0;c<platos.length;c++){
                table+=datos[f][c]+" ";
            }
            table+="\n";
        }
        JOptionPane.showMessageDialog(null,"         "+platos.toString()+"\n"+table);
    }
    
}

