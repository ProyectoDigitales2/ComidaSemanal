/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Rogencio
 */
public class Estatico {
    public static void ventanaEmergente(FXMLLoader ventanaEmergente, Parent root, String title){
        try {
            Parent root1= (Parent) ventanaEmergente.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.initOwner(root.getScene().getWindow() );            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Estatico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ShowWindow(Scene scene, String title, String url, Parent root) {    
        Stage st= new Stage();
        st.setScene(scene);
        st.setTitle(title);
        st.initModality(Modality.WINDOW_MODAL);
        st.getIcons().add(new Image(url));
        st.initOwner(root.getScene().getWindow() );
        st.showAndWait();
    }
}
