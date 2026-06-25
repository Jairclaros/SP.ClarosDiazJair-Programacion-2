/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Archivo;
import models.Producto;
import models.Sistema;

/**
 * FXML Controller class
 *
 * @author jairj
 */
public class PrincipalSistemaController implements Initializable {



    @FXML
    private ListView<Producto> listViewProductos;
    
    @FXML
    private Button btnAgregarProducto;
    
    @FXML
    private Button btnModificarProducto;
    
    @FXML
    private Button btnEliminarProducto;
    
    private static Sistema sistema = new Sistema();
    
    public static Sistema getSistema(){
        return sistema;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sistema.setProveedores(Archivo.leerProveedores());
        sistema.setProductos(Archivo.leerProductos());
        
        cargarLista();
    }    
    
    private void cargarLista(){
    
        listViewProductos.getItems().setAll(sistema.getProductos());
        
    
    }
    
    @FXML
    private void agregar(ActionEvent e) throws IOException{
    
        this.abrirFormularioProducto();
        cargarLista();
    
    }
    
    @FXML
    private void modificar(ActionEvent e) throws IOException{
    
        Producto p = listViewProductos.getSelectionModel().getSelectedItem();
        
        if(p != null){
        
            abrirFormularioProducto(p);
            cargarLista();
        }
    
    }
    
    private void abrirFormularioProducto() throws IOException{
        try {    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FormularioProducto.fxml"));
        
        Parent root = loader.load();
        
        FormularioProductoController controller = loader.getController();
        
        
        Stage stage = new Stage();
        
        stage.setScene(new Scene(root));
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.showAndWait();
      
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}
    
        private void abrirFormularioProducto(Producto p) throws IOException{
        try {    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/FormularioProducto.fxml"));
        
        Parent root = loader.load();
        
        FormularioProductoController controller = loader.getController();
        
        controller.cargarProducto(p);
        
        Stage stage = new Stage();
        
        stage.setScene(new Scene(root));
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.showAndWait();}
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }}
        
        
    @FXML
    private void eliminar(ActionEvent e){
    
        Producto p = listViewProductos.getSelectionModel().getSelectedItem();
        
        if (p != null){
            
               Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
               alerta.setTitle("Confirmar eliminacion");
               alerta.setHeaderText("Estas seguro que quiere eliminar el producto?");
               alerta.setContentText(p.toString());
                           
               Optional<ButtonType> resultado= alerta.showAndWait();
               
               if(resultado.isPresent() && resultado.get()== ButtonType.OK){
         
                    sistema.eliminarProducto(p);
                    Archivo.guardarProductos(sistema.getProductos());
                    cargarLista();}      
        
    
    }
    }
    
    
    
}
