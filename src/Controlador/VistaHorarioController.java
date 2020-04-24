/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;
import Modelo.Fecha_Comida;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaHorarioController implements Initializable {

    @FXML private Label lbl_fechaDomingos;
    
    @FXML private TextField txf_lunch_domingo;
    @FXML private TextField txf_lunch_lunes;
    @FXML private TextField txf_lunch_martes;
    @FXML private TextField txf_lunch_miercoles;
    @FXML private TextField txf_lunch_jueves;
    @FXML private TextField txf_lunch_viernes;
    @FXML private TextField txf_lunch_sabado;
    @FXML private TextField txf_dinner_domingo;
    @FXML private TextField txf_dinner_lunes;
    @FXML private TextField txf_dinner_martes;
    @FXML private TextField txf_dinner_miercoles;
    @FXML private TextField txf_dinner_jueves;
    @FXML private TextField txf_dinner_viernes;
    @FXML private TextField txf_dinner_sabado;
    
    private Comida modeloComida= new Comida();    
    private ObservableList<String> datosComida =modeloComida.cargarNombreComida();
    private ArrayList<TextField> textFieldsComida;
    private ArrayList<Label> textLabelsFechas;
    private ArrayList<Label> textDias;
    
    private Fecha_Comida modelo_fecha_comida= new Fecha_Comida();

    @FXML private DatePicker DatePicker;
    
    @FXML private Label lbl_fecha_domingo;
    @FXML private Label lbl_fecha_lunes;
    @FXML private Label lbl_fecha_martes;
    @FXML private Label lbl_fecha_miercoles;
    @FXML private Label lbl_fecha_jueves;
    @FXML private Label lbl_fecha_viernes;
    @FXML private Label lbl_fecha_sabado;
    
    @FXML private Label lbl_dia1;
    @FXML private Label lbl_dia2;
    @FXML private Label lbl_dia3;
    @FXML private Label lbl_dia4;
    @FXML private Label lbl_dia5;
    @FXML private Label lbl_dia6;
    @FXML private Label lbl_dia7;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textFieldsComida= new ArrayList<>();
        textLabelsFechas= new ArrayList<>();
        textDias= new ArrayList<>();
        
        almacenarTextFields();
        almacenarLabels();
        almacenarLabelsDias();
        //actualizar_horarios();
        
        for (TextField tf : textFieldsComida){
            TextFields.bindAutoCompletion(tf, datosComida);
        }
        
    }  
    
    private void almacenarTextFields(){
        textFieldsComida.add(txf_lunch_domingo);
        textFieldsComida.add(txf_lunch_lunes);
        textFieldsComida.add(txf_lunch_martes);
        textFieldsComida.add(txf_lunch_miercoles);
        textFieldsComida.add(txf_lunch_jueves);
        textFieldsComida.add(txf_lunch_viernes);
        textFieldsComida.add(txf_lunch_sabado);
        textFieldsComida.add(txf_dinner_domingo);
        textFieldsComida.add(txf_dinner_lunes);
        textFieldsComida.add(txf_dinner_martes);
        textFieldsComida.add(txf_dinner_miercoles);
        textFieldsComida.add(txf_dinner_jueves);
        textFieldsComida.add(txf_dinner_viernes);
        textFieldsComida.add(txf_dinner_sabado);
    }
    
    private void almacenarLabels(){
        textLabelsFechas.add(lbl_fecha_domingo);
        textLabelsFechas.add(lbl_fecha_lunes);
        textLabelsFechas.add(lbl_fecha_martes);
        textLabelsFechas.add(lbl_fecha_miercoles);
        textLabelsFechas.add(lbl_fecha_jueves);
        textLabelsFechas.add(lbl_fecha_viernes);
        textLabelsFechas.add(lbl_fecha_sabado);
    }
    
    private void almacenarLabelsDias(){
        textDias.add(lbl_dia1);
        textDias.add(lbl_dia2);
        textDias.add(lbl_dia3);
        textDias.add(lbl_dia4);
        textDias.add(lbl_dia5);
        textDias.add(lbl_dia6);
        textDias.add(lbl_dia7);
    }
    

    @FXML
    private void action_guardar_horario(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("¿Desea guardar esta planificación?");
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK){
            int j=0;
            String tipoC="ALMUERZO";
            for (int i = 0; i<textFieldsComida.size(); i++){   
                String comida="";
                if(!textFieldsComida.get(i).getText().isEmpty())
                    comida=textFieldsComida.get(i).getText();
                if(i<7){
                    String fechas=textLabelsFechas.get(i).getText();
                    modelo_fecha_comida.agregar_fecha_comida(comida, Date.valueOf(fechas), tipoC);
                    System.out.println(textFieldsComida.get(i).getText()+" Almuerzo "+textLabelsFechas.get(i).getText());                    
                }
                else{
                    tipoC="MERIENDA";
                    String fechas=textLabelsFechas.get(j).getText();
                    modelo_fecha_comida.agregar_fecha_comida(comida, Date.valueOf(fechas), tipoC);
                    System.out.println(textFieldsComida.get(i).getText()+" Merienda"+textLabelsFechas.get(j).getText());
                    j++;
                }
            }
        }
    }

    @FXML
    private void action_borrar_planificacion(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        for(TextField t : textFieldsComida)
            t.setText("");
        
        a.setContentText("Campos borrados");
        a.show();
    }    
    

    @FXML private void seleccionar_fecha(ActionEvent event) {
        LocalDate d = DatePicker.getValue();
        System.err.println(d);
        if(d!=null){
            for(int i=0; i<7;i++){ 
                LocalDate ld=d.plusDays(i);
                textLabelsFechas.get(i).setText(String.format(ld+""));
                String dia=traducirFecha(ld.getDayOfWeek()+"");
                textDias.get(i).setText(dia);
            }
        }
    }
    
    private String traducirFecha(String DayOfWeek){
        String dia="";
        switch(DayOfWeek){
            case "MONDAY":
                dia= "LUNES";         
                break;
            case "TUESDAY":
                dia= "MARTES";         
                break;
            case "WEDNESDAY":
                dia= "MIERCOLES";         
                break;    
            case "THURSDAY":
                dia= "JUEVES";         
                break;
            case "FRIDAY":
                dia= "VIERNES";         
                break;
            case "SATURDAY":
                dia= "SÁBADO";         
                break;
            case "SUNDAY":
                dia= "DOMINGO";         
                break;
        }
        return dia;
    }
}
