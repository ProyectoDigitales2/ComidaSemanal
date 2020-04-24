/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Comida;
import Modelo.Ingrediente;
import Modelo.Plato;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaAgregarComidaController implements Initializable{

    @FXML private JFXTextField tf_agregar_comida;
    
    @FXML private JFXComboBox<Categoria> cb_choose_category;   
    
    private Categoria modeloCategoria= new Categoria();
    private Ingrediente modeloIngrediente = new Ingrediente();
    private Comida comida = new Comida();
    private Plato plato = new Plato();
    
    private ObservableList<Categoria> cargarCategoria=modeloCategoria.cargarCategoria();
    private ObservableList<String> cargarIngredientes = modeloIngrediente.cargarNombreIngredientes();
    
    private ObservableList<String> cargarComida = comida.cargarNombreComida();
    
    private ArrayList<TextField> textFields= new ArrayList<>();
    @FXML private JFXComboBox<String> cb_temperatura;  
    
    @FXML private TableView<?> Tbl_ingredientes;
    @FXML private TextField tf_ingrediente;
    @FXML private AnchorPane root;
    
    private String comidaSeleccionada="";

    public VistaAgregarComidaController(String text){
        comidaSeleccionada=text;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        //root.getStylesheets().add("/Recursos/Estilo/style1.css");   
        ObservableList<String> temperatura = FXCollections.observableArrayList( "CALIENTE", "FRIO" );
        cb_choose_category.setItems(cargarCategoria);
        cb_choose_category.getSelectionModel().selectFirst();
        for (TextField tf : textFields){
            TextFields.bindAutoCompletion(tf, cargarIngredientes);
        }
        cb_temperatura.setItems(temperatura);
        cb_temperatura.getSelectionModel().selectFirst();
        TextFields.bindAutoCompletion(tf_agregar_comida, cargarComida);
        System.out.println(cb_temperatura.getValue());
        System.out.println(cb_choose_category.getValue().getCategoria());
        
    }        
    

    private void action_agregar_comida(ActionEvent event) {
        String textoComida= tf_agregar_comida.getText().toUpperCase();   
        String textoTemperatura=cb_temperatura.getValue();
        String textoCategoria=cb_choose_category.getValue().getCategoria();
        if(textoComida.isEmpty()){
            Alert a = new Alert(Alert.AlertType.ERROR);    
            a.setContentText("Campo vacío, ingrese la nueva comida a agregar"); 
            a.show();
        }
        else{
            Boolean agregar_comida= comida.guardarComida(textoComida,textoTemperatura , textoCategoria);
            if(agregar_comida){
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);    
                a.setContentText("Comida guardada"); 
                a.show();
            }
            else{
                Alert a = new Alert(Alert.AlertType.ERROR);    
                a.setContentText("Comida Existente"); 
                a.show();
            }
            

        }
            
    }

    @FXML private void seleccionar_categoria(ActionEvent event) {
        System.out.println(cb_choose_category.getValue());
    }

    @FXML private void seleccionar_temperatura(ActionEvent event) {
        System.out.println(cb_temperatura.getValue());

    }

    @FXML private void action_agregar_ingredientes(ActionEvent event) {
        agregarNuevoIngrediente();
        String textoComida= tf_agregar_comida.getText().toUpperCase();
        Boolean validarAgregado=true;
        for(TextField t : textFields){
            String textoIngrediente= t.getText().toUpperCase();            
            if(!t.getText().isEmpty()){
                Boolean agregar_comida= plato.agregarPlato(textoComida,textoIngrediente);
                if(!agregar_comida)
                    validarAgregado=false; 
            }
        }
        if(validarAgregado){
            JOptionPane.showMessageDialog(null, "Plato agregado exitosamente");
            tf_agregar_comida.setText("");
            for(TextField t : textFields)
                t.setText("");
        }
        else
            JOptionPane.showMessageDialog(null, "Error al agregar plato","ERROR" ,JOptionPane.WARNING_MESSAGE);          
            
    }
    
    /**
     * Agrega un ingrediente en caso de no haberlo registrado antes
     */
    private void agregarNuevoIngrediente(){
        for(TextField t : textFields){
            String textoIngrediente= t.getText().toUpperCase().trim();
            Boolean ingrediente=modeloIngrediente.guardarIngrediente(textoIngrediente);
            if(ingrediente && !textoIngrediente.isEmpty())
                System.out.println("Agregado nuevo ingrediente: "+t.getText());
        }
    }

    @FXML
    private void btn_agregar_ingrediente(ActionEvent event) {
    }

    @FXML
    private void btn_eliminar_ingrediente(ActionEvent event) {
    }
    
    public Parent getRoot() {
        return root;
    }
    
}
