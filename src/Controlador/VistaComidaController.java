/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;
import Modelo.Estatico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
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
public class VistaComidaController implements Initializable {

    @FXML private TableView tbl_comida;
    
    @FXML private TextField tf_eliminarcomida;
    
    @FXML private TableColumn<Comida, String> CComidaNombre;
    @FXML private TableColumn<Comida, String> CComidaCategoria;

    private ObservableList<Comida> datosComida =null;
    private Comida modeloComida= new Comida();
    private ObservableList<String> datosNombreComida =modeloComida.cargarNombreComida();
    public static Boolean validarActualizarTabla = false;
    @FXML private AnchorPane root;
    
    private ObservableList rowListCompSeleccionado;
    private String comidaSeleccionada="";
    @FXML
    private ImageView img_vercomida;
    private String Query="select c.nombre as Nombre, ca.categoria as Categoría from comida c, categoria ca where c.id_categoria = ca.id_categoria";
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
        Estatico.obtenerTablaDinamica(-1, Query , tbl_comida, "tbl_comida");        
    }
    
    @FXML
    private void action_añadir_comida(ActionEvent event) {
        VistaAgregarComida vac= new VistaAgregarComida("");
        Estatico.ShowWindow(new Scene(vac.getRoot()), "PLATO", "/Recursos/Imagenes/parrilla.png", root);        
    }

    @FXML
    private void action_eliminar_comida(ActionEvent event) {
        
        if(tf_eliminarcomida.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Campo vacío, ingrese la comida a eliminar","ERROR" ,JOptionPane.WARNING_MESSAGE);
        else if(modeloComida.eliminarComida(tf_eliminarcomida.getText().toUpperCase())){
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
        rowListCompSeleccionado = (ObservableList) tbl_comida.getSelectionModel().getSelectedItem();
        if (rowListCompSeleccionado != null) {
            System.out.println(rowListCompSeleccionado.get(0).toString());
            comidaSeleccionada = rowListCompSeleccionado.get(0).toString();
            tf_eliminarcomida.setText(comidaSeleccionada);
            img_vercomida.setEffect(new DropShadow(25, Color.web("#216500")));
        }

    }

    @FXML
    private void action_ver_comida(MouseEvent event) {
        if(!comidaSeleccionada.isEmpty()){
            VistaAgregarComida vac= new VistaAgregarComida(comidaSeleccionada);
            Estatico.ShowWindow(new Scene(vac.getRoot()), "PLATO", "/Recursos/Imagenes/parrilla.png", root);
        }        
    }

    @FXML
    private void exited_img(MouseEvent event) {
        img_vercomida.setFitHeight(99);
        img_vercomida.setFitWidth(99);
    }

    @FXML
    private void entered_img(MouseEvent event) {
        img_vercomida.setFitHeight(120);
        img_vercomida.setFitWidth(120);
    }
    
}
