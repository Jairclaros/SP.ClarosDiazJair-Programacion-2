/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author jairj
 */
public class Electronico extends Producto{
    
    private int garantia;

    public Electronico() {
        
    }

    public Electronico(String codigo, String marca, String modelo, double precio, int stock, Proveedor proveedor, int garantia) {
        super(codigo, marca, modelo, precio, stock, proveedor);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    
    
    
    
}
