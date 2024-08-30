/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante;

import javax.swing.JOptionPane;

import java.util.Arrays;

/**
 *
 * @author SCIS2-27
 */
public class Menu {
    
    String platos[];
    int datos[][];
    String datos2[][];
    String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    String dias2[] = {"Lun","Mar","Mie","Jue","Vie","Sab"};
    int cant_platos[];
    int cant_dias[];
    PlatosClass platos2[];
    
    public void crearMenu(int cantidad){
        
        platos2 = new PlatosClass[cantidad];
        
        platos = new String[cantidad];
        int x = 0;
        while(x<cantidad){
            String name = JOptionPane.showInputDialog("Ingrese el nombre del plato "+(x+1));
            int price = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del plato: "+(x+1)));
            platos2[x] = new PlatosClass(price,name);
            x++;
        }
        
        /**
         * int i = 0;
        while(i<cantidad){
            platos[i]=JOptionPane.showInputDialog("Diga el nombre del plato "+(i+1));
            i++;
        }
        
         * 
 */
        datos2 = new String[7][(platos2.length+1)];
        for(int c=1;c<(platos2.length+(1));c++){
                datos2[0][c]=platos2[(c-1)].getNombre();
        }
        for(int f=1;f<7;f++){
            datos2[f][0]=dias2[(f-1)];
        }
    }
    public void consultarMenu(){
        String list_platos = "";
        for(int i = 0; i<platos2.length;i++){
            list_platos += platos2[i].getNombre()+" $"+platos2[i].getPrecio()+"\n";
            
        }
        JOptionPane.showMessageDialog(null, "Platos: \n"+list_platos);
        
                
    }
    public void ingresarDatos(){
        datos = new int[7][(platos2.length+1)];
        
        for(int f = 1;f<7;f++){
            for(int c = 1;c<(platos2.length+1);c++){
                datos[f][c]=Integer.parseInt(JOptionPane.showInputDialog(null, "Ventas para el día "+dias[(f-1)]+" plato: "+platos2[(c-1)].getNombre()));
                datos2[f][c]=Integer.toString(datos[f][c]);
            }
        }
        datos2[0][0]="_______";
        
    }
    public void mostrarDatos(){
        String table = "";
            for(int c = 0;c<(platos2.length+1);c++){
                table+=" _ "+datos2[0][c]+" _ ";
            }
            table+="\n";
        for(int f = 1;f<7;f++){
            for(int c = 0;c<(platos2.length+1);c++){
                table+=" ___ "+datos2[f][c]+" ___ ";
            }
            table+="\n";
        }
        JOptionPane.showMessageDialog(null,table);
    }
    
    public void cantidadPlatos(){
        cant_platos = new int[(platos2.length+1)];
        cant_dias = new int[6];
        
        
        for(int c = 1;c<(platos2.length+1);c++){
            for(int f = 1;f<7;f++){
                cant_platos[platos2.length] += datos[f][c];
                cant_platos[c-1]+= datos[f][c];
            }
        }
        
        for(int f = 1;f<7;f++){
            for(int c = 1;c<(platos2.length+1);c++){
                cant_dias[f-1]+= datos[f][c];
            }
        }
        
        int plato_mas = 0;
        int posi_mas = 0;
        int plato_menos = cant_platos[0];
        int posi_menos=0;
        for(int i = 0; i<platos2.length;i++){
            if(cant_platos[i] >= plato_mas){
                plato_mas = cant_platos[i];
                posi_mas = i;
            }
            if(cant_platos[i]<=plato_menos){
                plato_menos = cant_platos[i];
                posi_menos = i;
            }
        }
        
        
        int mas = 0;
        int indexmas = 0;
        for(int i = 0; i<6; i++){
            if(cant_dias[i] >= mas){
                mas = cant_dias[i];
                indexmas = i;
            } 
        }
        int menos = cant_dias[0];
        int indexmenos = 0;
        for(int i = 0; i<6; i++){
            if(cant_dias[i] <= menos){
                menos = cant_dias[i];
                indexmenos = i;
            } 
        }
        
        String message = "";
        message += "- Día con más ventas: "+dias[indexmas]+" ("+mas+")"+"\n";
        message += "- Día con menos ventas: "+dias[indexmenos]+" ("+menos+")"+"\n";
        for(int i=0;i<platos2.length;i++){
            message += "- Total "+ platos2[i].getNombre()+" en la semana: "+cant_platos[i]+"\n";
        }
        message += "- Total platos: "+ cant_platos[platos.length]+"\n";
        message += "- Promedio de platos por día: "+(cant_platos[platos2.length]/6);
        JOptionPane.showMessageDialog(null,message);
        
        
        String message2 = "";
        message2 += "- Plato más vendido de la semana: "+platos2[posi_mas].getNombre()+" ("+plato_mas+")"+"\n";
        message2 += "- Plato menos vendido de la semana: "+platos2[posi_menos].getNombre()+" ("+plato_menos+")"+"\n";
        JOptionPane.showMessageDialog(null,message2);
    }
}

