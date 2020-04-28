/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estatico;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaIngredienteController implements Initializable {

    @FXML
    private TableView tbl_ingredientes;
    
    @FXML private JFXTextField tf_agregar;
    
    @FXML private JFXTextField tf_eliminar;
    @FXML private TableColumn<Ingrediente, String> CIngredienteNombre;
    
    private ObservableList<Ingrediente> registroIngrediente =null;
    private Ingrediente modeloIngrediente= new Ingrediente();
    private ObservableList<String> cargarIngredientes = modeloIngrediente.cargarNombreIngredientes();
    @FXML private AnchorPane root;
    private ObservableList rowListCompSeleccionado;
    private String ingrdSeleccionado="";
    private Integer id_ingrediente=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {          
        //root.getStylesheets().add("/Recursos/Estilo/style1.css");  
        Estatico.obtenerTablaDinamica(-1, modeloIngrediente.obtenerIngredientes, tbl_ingredientes, "tbl_ingrediente");
        CIngredienteNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TextFields.bindAutoCompletion(tf_agregar, cargarIngredientes);
        TextFields.bindAutoCompletion(tf_eliminar, cargarIngredientes);
    }    
    

    @FXML private void action_añadir_ingrediente(ActionEvent event) {
        if(tf_agregar.getText().isEmpty() || tf_agregar.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Campo vacío, ingrese el ingrediente a agregar","ERROR" ,JOptionPane.WARNING_MESSAGE);
        else{
            if(modeloIngrediente.guardarIngrediente(tf_agregar.getText().toUpperCase().trim())){
                JOptionPane.showMessageDialog(null, "Ingrediente guardado correctamente");  
                tf_agregar.setText("");       
                Estatico.obtenerTablaDinamica(-1, modeloIngrediente.obtenerIngredientes, tbl_ingredientes, "tbl_ingrediente");
        
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
            if(modeloIngrediente.modificarIngrediente(tf_eliminar.getText().toUpperCase().trim(), id_ingrediente)){
                JOptionPane.showMessageDialog(null, "Ingrediente "+tf_eliminar.getText()+" modificado exitosamente");
                tf_eliminar.setText("");      
                Estatico.obtenerTablaDinamica(-1, modeloIngrediente.obtenerIngredientes, tbl_ingredientes, "tbl_ingrediente");
        
            }
            else
                JOptionPane.showMessageDialog(null, "Error al modificar ingrediente","ERROR" ,JOptionPane.WARNING_MESSAGE); 
        }
        
    }

    @FXML
    private void action_tbl_ingrd(MouseEvent event) {
        rowListCompSeleccionado = (ObservableList) tbl_ingredientes.getSelectionModel().getSelectedItem();
        if (rowListCompSeleccionado != null) {
            id_ingrediente = Integer.valueOf(rowListCompSeleccionado.get(1).toString());
            ingrdSeleccionado = rowListCompSeleccionado.get(0).toString();
            tf_eliminar.setText(ingrdSeleccionado);
            System.out.println(rowListCompSeleccionado);
        }
    }
    
}
