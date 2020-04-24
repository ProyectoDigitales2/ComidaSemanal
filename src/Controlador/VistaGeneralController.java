/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaGeneralController implements Initializable {

    @FXML
    private JFXButton btn_ingredientes;
    @FXML
    private JFXButton btn_comida;
    @FXML
    private JFXButton btn_horario;
    @FXML
    private JFXButton btn_listado;
    @FXML
    private Pane parent_root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaIngrediente.fxml")));
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void ir_ingredientes(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaIngrediente.fxml")));
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_comida(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaComida.fxml")));
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_horario(ActionEvent event) {
        try {
            AnchorPane vistaCARuta = FXMLLoader.load(getClass().getResource(("/Vista/VistaHorario.fxml")));
            parent_root.getChildren().setAll(vistaCARuta);
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ir_listado(ActionEvent event) {
    }
    
}
