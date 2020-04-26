/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ingrediente;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaIngredienteController implements Initializable {

    @FXML
    private TableView<Ingrediente> tbl_ingredientes;
    
    @FXML private JFXTextField tf_agregar;
    
    @FXML private JFXTextField tf_eliminar;
    @FXML private TableColumn<Ingrediente, String> CIngredienteNombre;
    
    private ObservableList<Ingrediente> registroIngrediente =null;
    private Ingrediente modeloIngrediente= new Ingrediente();
    private ObservableList<String> cargarIngredientes = modeloIngrediente.cargarNombreIngredientes();
    @FXML private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {          
        //root.getStylesheets().add("/Recursos/Estilo/style1.css");   
        CIngredienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        llenarTablaIngrediente();
        TextFields.bindAutoCompletion(tf_agregar, cargarIngredientes);
        TextFields.bindAutoCompletion(tf_eliminar, cargarIngredientes);
    }    
    
    private void llenarTablaIngrediente(){
        if(registroIngrediente==null){
            registroIngrediente=modeloIngrediente.cargarIngredientes();
            tbl_ingredientes.setItems(registroIngrediente);
        }else{
            registroIngrediente.removeAll(registroIngrediente);
            registroIngrediente = modeloIngrediente.cargarIngredientes();
            tbl_ingredientes.setItems(registroIngrediente);
        }
        
    }

    @FXML private void action_añadir_ingrediente(ActionEvent event) {
        if(tf_agregar.getText().isEmpty() || tf_agregar.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Campo vacío, ingrese el ingrediente a agregar","ERROR" ,JOptionPane.WARNING_MESSAGE);
        else{
            if(modeloIngrediente.guardarIngrediente(tf_agregar.getText().toUpperCase())){
                JOptionPane.showMessageDialog(null, "Ingrediente guardado correctamente");  
                tf_agregar.setText("");
                llenarTablaIngrediente();                  
            }            
            else
                JOptionPane.showMessageDialog(null, "Ingrediente Existente","ERROR" ,JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    private void action_eliminar_ingrediente(ActionEvent event) {
        if(tf_eliminar.getText().isEmpty() || tf_eliminar.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Campo vacío, ingrese el ingrediente a modificar","ERROR" ,JOptionPane.WARNING_MESSAGE);
        else {                  
            if(modeloIngrediente.modificarIngrediente(tf_eliminar.getText().toUpperCase())){
                JOptionPane.showMessageDialog(null, "Ingrediente "+tf_eliminar.getText()+" modificado exitosamente");
                tf_eliminar.setText("");
                llenarTablaIngrediente();                
            }
            else
                JOptionPane.showMessageDialog(null, "Error al modificar ingrediente","ERROR" ,JOptionPane.WARNING_MESSAGE); 
        }
        
    }
    
}
