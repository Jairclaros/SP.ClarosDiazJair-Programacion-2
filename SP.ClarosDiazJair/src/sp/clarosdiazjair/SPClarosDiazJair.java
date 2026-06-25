/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp.clarosdiazjair;

import controllers.PrincipalSistemaController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jairj
 */
public class SPClarosDiazJair extends Application {


    @Override
    public void start(Stage stage) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalSistema.fxml"));

        Parent root = loader.load(); 
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Sistema de Productos");


        stage.show();}

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
