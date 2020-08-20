/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Fecha_Comida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Rogencio
 */
public class VistaRanking7 {
    private BorderPane root;
    private Label lb_title, lb_ranking;
    private HBox hb_title;
    private VBox vbos_ranks;
    
    private Fecha_Comida modelo_fecha_comida= new Fecha_Comida();

    public VistaRanking7() {
        initialize();
        root.setTop(hb_title);
        root.setCenter(lb_ranking);
    }
    
    private void initialize(){
        root = new BorderPane();
        lb_title = new Label("Ranking 7 Comidas del Mes"); 
        hb_title = new HBox(lb_title);
        hb_title.setAlignment(Pos.CENTER);
        hb_title.setPadding(new Insets(15));
        
        vbos_ranks = new VBox();
        recargarRanking();
        /*lb_ranking = new Label(modelo_fecha_comida.cargarRanking()+"");
        System.out.println(modelo_fecha_comida.cargarRanking());*/
    }
    
    private void recargarRanking(){
        
        int tamanio = modelo_fecha_comida.cargarRanking().size();
        System.out.println(tamanio);
        for(int i = 0; i<tamanio; i++){
            System.out.println(modelo_fecha_comida.cargarRanking().get(i));
        }
    }

    public BorderPane getRoot() {
        return root;
    }
    
    
    
}
