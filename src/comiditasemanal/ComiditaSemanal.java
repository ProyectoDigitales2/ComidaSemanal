/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comiditasemanal;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Rogencio
 */
public class ComiditaSemanal extends Application {
    private Stage stagePrincipal;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stagePrincipal= stage;
        ScenePrincipal();
    }
    
    public void ScenePrincipal() throws IOException{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/VistaGeneral.fxml"));///Vista/VistaGerente.fxml

            Scene scene = new Scene(root);
            stagePrincipal.setScene(scene);
            Image image = new Image("/Recursos/Imagenes/logo.png");
            stagePrincipal.getIcons().add(image);
            stagePrincipal.show();            
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
