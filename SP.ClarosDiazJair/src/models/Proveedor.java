/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Objects;

/**
 *
 * @author jairj
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String razonSocial;
    private String telefono;
    private String email;
    private String ciudad;
    
    public Proveedor(){}

    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Proveedor(int id, String razonSocial, String telefono, String email, String ciudad) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.razonSocial);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.ciudad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.razonSocial, other.razonSocial)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.ciudad, other.ciudad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proveedor: ");
        sb.append("id: ").append(id);
        sb.append(", Razon Social: ").append(razonSocial);
        sb.append(", Telefono: ").append(telefono);
        sb.append(", Email: ").append(email);
        sb.append(", Ciudad: ").append(ciudad);
        return sb.toString();
    }
    
    
    
}
