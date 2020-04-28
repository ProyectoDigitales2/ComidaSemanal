/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estatico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Rogencio
 */
public class VistaListadoController implements Initializable {

    @FXML private TableView tbl_comida;
    @FXML private TableView tbl_ingrdt;
    @FXML private DatePicker dp_desde;
    @FXML private DatePicker dp_hasta;

    private final String QueyComida = "select c.nombre as nombre \n"
            + "from comida c, fecha_comida fc \n"
            + "where c.id_comida= fc.id_comida and fc.fecha between '";
    private final String QueryIngrediente="select distinct i.nombre from ingrediente i, comida c, plato pl , fecha_comida fc \n" +
"where c.id_comida= fc.id_comida and pl.id_comida=c.id_comida and i.id_ingrediente=pl.id_ingrediente\n" +
" and fc.fecha between '";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private void action_btnDesde(ActionEvent event) {
        if(dp_desde.getValue()!= null){
            Estatico.obtenerTablaDinamica(-1, QueyComida+dp_desde.getValue()+"' and DATE_ADD( '"+dp_desde.getValue()+"' , INTERVAL 7 DAY)", tbl_comida, "tbl_comida");
            Estatico.obtenerTablaDinamica(-1, QueryIngrediente+dp_desde.getValue()+"' and DATE_ADD( '"+dp_desde.getValue()+"' , INTERVAL 7 DAY)", tbl_ingrdt, "tbl_ingrd");
        }
        
    }

    @FXML private void action_btntodo(ActionEvent event) {
        if(dp_desde.getValue()!= null && dp_hasta.getValue()!= null){
            Estatico.obtenerTablaDinamica(-1, QueyComida+dp_desde.getValue()+"' and '"+dp_hasta.getValue()+"' ;", tbl_comida, "tbl_comida");
            Estatico.obtenerTablaDinamica(-1, QueryIngrediente+dp_desde.getValue()+"' and '"+dp_hasta.getValue()+"' ;", tbl_ingrdt, "tbl_ingrd");
        }
    }

    
}
