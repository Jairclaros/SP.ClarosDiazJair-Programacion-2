/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.CodigoDuplicadoException;
import java.util.ArrayList;

/**
 *
 * @author jairj
 */
public class Sistema {
    
    private ArrayList<Producto> productos;
    private ArrayList<Proveedor> proveedores;
    
    public Sistema(){
    
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();
        
    }
    
    public Producto buscarProducto(String codigo){
        
        for (Producto producto : productos) {
            
            if(producto.getCodigo().equals(codigo)){
                return producto;}
            
        }
        
        return null;
        
    }
    
    public void agregarProducto(Producto p) throws CodigoDuplicadoException{
        
        if(buscarProducto(p.getCodigo()) != null){
            throw new CodigoDuplicadoException("Codigo Repetido");}
        else{
            productos.add(p);}
        
        }
    
    public void eliminarProducto(Producto p){
    
        productos.remove(p);
    }
    
    public double valorTotalInventario(){
        
        double total = 0;
        
        for (Producto producto : productos) {
            total += producto.valorInventario();
            
        }
        
        return total;
    
    }
    
    public boolean existeCodigo(String codigo) {

    for (Producto p : productos) {
        if (p.getCodigo().equals(codigo)) {
            return true;
        }
    }
    return false;
}

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    
}
    