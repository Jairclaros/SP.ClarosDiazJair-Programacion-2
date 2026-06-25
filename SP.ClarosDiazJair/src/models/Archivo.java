/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jairj
 */
public class Archivo {
    
    public static ArrayList<Proveedor> leerProveedores(){
        
        ArrayList<Proveedor> lista = new ArrayList<>();
        
        try {
            
            Gson gson = new Gson();
            
            Type type = new TypeToken<ArrayList<Proveedor>>(){}.getType();
            
            lista = gson.fromJson(new FileReader("proveedores.json"),type);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    
    }
    
    public static void guardarProductos(ArrayList<Producto> productos){
    
    
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            FileWriter fw = new FileWriter("productos.json");
            
            fw.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    
    }
    
    public static ArrayList<Producto> leerProductos() {

    try {

        Gson gson = new Gson();

        Reader reader = new FileReader("productos.json");

        ArrayList<Producto> lista = gson.fromJson(
                reader,
                new TypeToken<List<Producto>>() {}.getType()
        );

        reader.close();

        return lista != null ? lista : new ArrayList<>();

    } catch (Exception e) {
        System.out.println("Error leyendo productos: " + e.getMessage());
        return new ArrayList<>();
    }
}
    
}
