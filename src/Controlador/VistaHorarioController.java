/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;
import Modelo.Estatico;
import Modelo.Fecha_Comida;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaHorarioController implements Initializable {
    
    
    private Comida modeloComida= new Comida();    
    private ObservableList<String> datosComida =modeloComida.cargarNombreComida();    
    private Fecha_Comida modelo_fecha_comida= new Fecha_Comida();
    private ObservableList rowListCompSeleccionado;

    private DatePicker DatePicker;
    
    @FXML private DatePicker dp_planificacion;
    @FXML private TableView tbl_planificación;
    @FXML private TextField tf_comida;
    @FXML private DatePicker dp_fechacomida;
    @FXML private ComboBox cb_tipo;
    @FXML private Button btn_guardar_horario;
    @FXML private Button btn_modificarhorario;
    @FXML private Button btn_eliminarhorario;
    
    public final String get_fecha_comida = "select fa.fecha as Fecha, c.nombre as Comida, fa.tipo as Tipo, fa.id_fecha_comida as ID \n" +
"from fecha_comida fa join comida c on c.id_comida= fa.id_comida\n" +
"where fa.fecha between '";
    private String Query;
    private Integer id_fechaplanificada;
    @FXML
    private AnchorPane root;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_tipo.getItems().addAll("DESAYUNO","ALMUERZO","MERIENDA"); cb_tipo.setValue("ALMUERZO");
        TextFields.bindAutoCompletion(tf_comida, datosComida);
    }  
        

    @FXML
    private void action_guardar_horario(ActionEvent event) {
        if(tf_comida.getText().isEmpty() || dp_fechacomida.getValue()==null)
            Estatico.alertas_warning("Campos Vacíos", "Ingrese el nombre de la Comida y de la Fecha Planificada.");
        else{
            System.out.println(tf_comida.getText()+" "+ 
                    dp_fechacomida.getValue().toString()+" "+                    
                    cb_tipo.getValue().toString());
            if(modelo_fecha_comida.agregar_fecha_comida(tf_comida.getText().toUpperCase().trim(), 
                    dp_fechacomida.getValue().toString(), 
                    cb_tipo.getValue().toString())){
                    Estatico.alertas_information("Planificación Agregada", "", Pos.TOP_CENTER);
                    reset_table();
            }else{
                Estatico.alertas_warning("ERROR", "Error en los datos o desconexión.");
            }
        }

    }      

    
    @FXML private void seleccionar_fecha(ActionEvent event) {
        if(dp_planificacion.getValue()!=null){
            tf_comida.setDisable(false);
            dp_fechacomida.setDisable(false);
            cb_tipo.setDisable(false);
            btn_eliminarhorario.setDisable(false);
            btn_guardar_horario.setDisable(false);
            btn_modificarhorario.setDisable(false);
            dp_fechacomida.setValue(dp_planificacion.getValue());
            reset_table();
        }
    }

    @FXML
    private void action_table_planificacion(MouseEvent event) {
        rowListCompSeleccionado = (ObservableList) tbl_planificación.getSelectionModel().getSelectedItem();
        if (rowListCompSeleccionado != null) {
            System.out.println(rowListCompSeleccionado.toString());
            tf_comida.setText(rowListCompSeleccionado.get(1).toString());
            dp_fechacomida.setValue(LocalDate.parse(rowListCompSeleccionado.get(0).toString()));
            cb_tipo.setValue(rowListCompSeleccionado.get(2).toString());
            id_fechaplanificada = Integer.valueOf(rowListCompSeleccionado.get(3).toString());
        }
    }


    @FXML
    private void action_modificarhorario(ActionEvent event) {
        if(tf_comida.getText().isEmpty() || dp_fechacomida.getValue()==null)
            Estatico.alertas_warning("Campos Vacíos", "Ingrese el nombre de la Comida y de la Fecha Planificada.");
        else{
            System.out.println(tf_comida.getText()+" "+ 
                    dp_fechacomida.getValue().toString()+" "+                    
                    cb_tipo.getValue().toString());
            if(modelo_fecha_comida.modificar_fecha_comida(  
                    tf_comida.getText().toUpperCase().trim(),
                    dp_fechacomida.getValue().toString(),
                    cb_tipo.getValue().toString(), id_fechaplanificada)){
                    nohaytext();
                    Estatico.alertas_information("Planificación Modificada", "", Pos.TOP_CENTER);
                    reset_table();
            }else{
                Estatico.alertas_warning("ERROR", "Error en los datos o desconexión.");
            }
        }
    }

    @FXML
    private void action_eliminarhorario(ActionEvent event) {
        if(tf_comida.getText().isEmpty() || dp_fechacomida.getValue()==null)
            Estatico.alertas_warning("Campos Vacíos", "Ingrese el nombre de la Comida y de la Fecha Planificada.");
        else{
            System.out.println(tf_comida.getText()+" "+ 
                    dp_fechacomida.getValue().toString()+" "+                    
                    cb_tipo.getValue().toString());
            if(modelo_fecha_comida.eliminar_fecha_comida(id_fechaplanificada)){
                    nohaytext();
                    Estatico.alertas_information("Planificación Eliminada", "", Pos.TOP_CENTER);
                    reset_table();
            }else{
                Estatico.alertas_warning("ERROR", "Error en los datos o desconexión.");
            }
        }
    }
    
    private void reset_table(){
        Query = get_fecha_comida+dp_planificacion.getValue().toString()+"' and DATE_ADD( '"+dp_planificacion.getValue().toString()+"' , INTERVAL 7 DAY)";
        Estatico.obtenerTablaDinamica(-1, Query, tbl_planificación, "tbl_planificacion");        
    }
    
    private void nohaytext()
    {
        tf_comida.setText("");
        dp_fechacomida.setValue(null);
        dp_fechacomida.getEditor().clear();
    }

    @FXML
    private void btn_nuevacomida(ActionEvent event) {        
        VistaAgregarComida vac= new VistaAgregarComida("");
        Estatico.ShowWindow(new Scene(vac.getRoot()), "PLATO", "/Recursos/Imagenes/parrilla.png", root);  
    }


    @FXML
    private void action_filtrarfecha(MouseEvent event) {
        if(dp_planificacion.getValue()!=null){
            tf_comida.setDisable(false);
            dp_fechacomida.setDisable(false);
            cb_tipo.setDisable(false);
            btn_eliminarhorario.setDisable(false);
            btn_guardar_horario.setDisable(false);
            btn_modificarhorario.setDisable(false);
            dp_fechacomida.setValue(dp_planificacion.getValue());
            reset_table();
        }
    }
}
