/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import exceptions.CodigoDuplicadoException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Alimenticio;
import models.Archivo;
import models.Electronico;
import models.Producto;
import models.Proveedor;

/**
 * FXML Controller class
 *
 * @author jairj
 */
public class FormularioProductoController implements Initializable {
    
    @FXML
    private TextField txtCodigo;
    
    @FXML
    private TextField txtMarca;
    
    @FXML
    private TextField txtModelo;
    
    @FXML
    private TextField txtPrecio;
    
    @FXML
    private TextField txtStock;
    
    @FXML
    private ComboBox<String> cbTipo;
    
    @FXML
    private TextField txtDatoExtra;
    
    @FXML
    private ComboBox<Proveedor> cbProveedor;
    
    @FXML
    private Label lblDatoExtra;
    
    @FXML
    private Button btnguardar;
    
    @FXML
    private Button btnCancelar;
    
    private boolean modificar = false;
    
    private Producto producto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtDatoExtra.setDisable(true);
        
        cbProveedor.getItems().addAll(new Proveedor(1, "Proveedor A"),new Proveedor(2, "Proveedor B"),new Proveedor(3, "Proveedor C"));
        
        cbTipo.getItems().addAll("Electronico","Alimenticio");
    } 
    
    @FXML
    private void cambiarTipo() {

        String tipo = cbTipo.getValue();

        // reset siempre
        txtDatoExtra.clear();
        txtDatoExtra.setDisable(true);
        lblDatoExtra.setText("Dato Extra");

        if (tipo == null) {
            return;
        }

        if (tipo.equals("Electronico")) {

            lblDatoExtra.setText("Garantía (meses)");
            txtDatoExtra.setDisable(false);

        } 
        else if (tipo.equals("Alimenticio")) {

            lblDatoExtra.setText("Fecha Vencimiento");
            txtDatoExtra.setDisable(false);
        }
    }
    
    @FXML
    public void cargarProducto(Producto p) {

        modificar = true;
        producto = p;

        txtCodigo.setText(p.getCodigo());
        txtCodigo.setDisable(true);

        txtMarca.setText(p.getMarca());
        txtModelo.setText(p.getModelo());
        txtPrecio.setText(String.valueOf(p.getPrecio()));
        txtStock.setText(String.valueOf(p.getStock()));

        cbProveedor.setValue(p.getProveedor());

        txtDatoExtra.setDisable(false);

        if (p instanceof Electronico e) {

            cbTipo.setValue("Electronico");
            lblDatoExtra.setText("Garantía (meses)");
            txtDatoExtra.setText(String.valueOf(e.getGarantia()));

        } else if (p instanceof Alimenticio a) {

            cbTipo.setValue("Alimenticio");
            lblDatoExtra.setText("Fecha Vencimiento");
            txtDatoExtra.setText(a.getFechaVencimiento());
        }
    }
    
    @FXML
    private void guardar(ActionEvent e) {

        try {

            if (!modificar) {
                agregarProducto();
            } else {
                modificarProducto();
            }
            cerrarVentana();

            Archivo.guardarProductos(PrincipalSistemaController.getSistema().getProductos()
            );

        } catch (CodigoDuplicadoException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
}
    
    private void modificarProducto(){

        producto.setMarca(txtMarca.getText());

        producto.setModelo(txtModelo.getText());

        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));

        producto.setStock(Integer.parseInt(txtStock.getText()));

        producto.setProveedor(cbProveedor.getValue());

        if(producto instanceof Electronico){

            ((Electronico) producto).setGarantia(Integer.parseInt(txtDatoExtra.getText()));
        }

        if(producto instanceof Alimenticio){
            ((Alimenticio) producto).setFechaVencimiento(
                            txtDatoExtra.getText());
        }
    }
    
    private void agregarProducto() throws CodigoDuplicadoException {

        String codigo = txtCodigo.getText();

        if (PrincipalSistemaController.getSistema().existeCodigo(codigo)) {
            throw new CodigoDuplicadoException("El código ya existe");
        }

        Producto nuevo;

        String tipo = cbTipo.getValue();

        if (tipo.equalsIgnoreCase("Electronico")) {

            nuevo = new Electronico(
                    codigo,
                    txtMarca.getText(),
                    txtModelo.getText(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtStock.getText()),
                    cbProveedor.getValue(),
                    Integer.parseInt(txtDatoExtra.getText())
            );

        } else {

            nuevo = new Alimenticio(
                    codigo,
                    txtMarca.getText(),
                    txtModelo.getText(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtStock.getText()),
                    cbProveedor.getValue(),
                    txtDatoExtra.getText()
            );
        }

        PrincipalSistemaController.getSistema().agregarProducto(nuevo);
    }
    
    
    @FXML
    private void cancelar(ActionEvent e){
    
        cerrarVentana();
    }
    
    @FXML
    private void cerrarVentana(){
    
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        
        stage.close();
        
    }
    
}
