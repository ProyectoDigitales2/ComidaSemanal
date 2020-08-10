/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaGeneralController implements Initializable {

    @FXML
    private Pane parent_root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaIngrediente.fxml")));
            vistaCARuta.getStylesheets().add("/Recursos/Estilo/style1.css"); 
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ir_ingredientes(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaIngrediente.fxml")));
            vistaCARuta.getStylesheets().add("/Recursos/Estilo/style1.css"); 
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_comida(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaComida.fxml")));
            vistaCARuta.getStylesheets().add("/Recursos/Estilo/style1.css"); 
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_horario(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaHorario.fxml")));
            vistaCARuta.getStylesheets().add("/Recursos/Estilo/style1.css");  
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_listado(ActionEvent event) {
        try {
            BorderPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaListado.fxml")));
            vistaCARuta.getStylesheets().add("/Recursos/Estilo/style1.css"); 
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
