/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;
import Modelo.Estatico;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaComidaController implements Initializable {

    @FXML private TableView<Comida> tbl_comida;
    
    @FXML private TextField tf_eliminarcomida;
    
    @FXML private TableColumn<Comida, String> CComidaNombre;
    @FXML private TableColumn<Comida, String> CComidaCategoria;

    private ObservableList<Comida> datosComida =null;
    private Comida modeloComida= new Comida();
    private ObservableList<String> datosNombreComida =modeloComida.cargarNombreComida();
    public static Boolean validarActualizarTabla = false;
    @FXML private AnchorPane root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //root.getStylesheets().add("/Recursos/Estilo/style1.css");   
        CComidaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        CComidaCategoria.setCellValueFactory(new PropertyValueFactory<>("catego"));
        llenarTablaComida();
        validarActualizarComida();
        TextFields.bindAutoCompletion(tf_eliminarcomida, datosNombreComida);
    }    

    private void llenarTablaComida(){
        if(datosComida==null){
            datosComida=modeloComida.cargarComida();
            tbl_comida.setItems(datosComida);
        }else{
            datosComida.removeAll(datosComida);
            datosComida = modeloComida.cargarComida();
            tbl_comida.setItems(datosComida);
        }
        
    }
    
    @FXML
    private void action_añadir_comida(ActionEvent event) {
        VistaAgregarComida vac= new VistaAgregarComida();
        Estatico.ShowWindow(new Scene(vac.getRoot()), "PLATO", "/Recursos/Imagenes/parrilla.png", root);
        
    }

    @FXML
    private void action_eliminar_comida(ActionEvent event) {
        Boolean eliminar_comida = modeloComida.eliminarComida(tf_eliminarcomida.getText().toUpperCase());
        if(tf_eliminarcomida.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Campo vacío, ingrese la comida a eliminar","ERROR" ,JOptionPane.WARNING_MESSAGE);
        else if(eliminar_comida){
            tf_eliminarcomida.setText("");
            JOptionPane.showMessageDialog(null, "Comida "+tf_eliminarcomida.getText()+ " borrada exitosamente");
            llenarTablaComida(); 
        }
        else
            JOptionPane.showMessageDialog(null, "Error al eliminar comida","ERROR" ,JOptionPane.WARNING_MESSAGE);
    }
    
    private void validarActualizarComida(){
        if(validarActualizarTabla){
            llenarTablaComida();
            validarActualizarTabla = false;            
        }
    }

    @FXML
    private void action_click_table(MouseEvent event) {
    }
    
}
