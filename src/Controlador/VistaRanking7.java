/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Fecha_Comida;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Rogencio
 */
public class VistaRanking7 {
    private BorderPane root;
    private Label lb_title;
    private HBox hb_title;
    private VBox vbos_ranks;
    private ImageView actualizar;
    private GridPane gp_ranking;
    
    private Fecha_Comida modelo_fecha_comida= new Fecha_Comida();

    public VistaRanking7() {
        initialize();
        root.setTop(hb_title);
        root.setCenter(vbos_ranks);
        root.setPadding(new Insets(20));
    }
    
    private void initialize(){
        root = new BorderPane();
        root.getStylesheets().add("/Recursos/Estilo/style1.css"); 
        actualizar = new ImageView("Recursos/Imagenes/actualizar.png");
        actualizar.setFitHeight(35);
        actualizar.setFitWidth(35);
        lb_title = new Label("Ranking 7 Comidas del Mes"); 
        lb_title.setId("tituloCentral");
        hb_title = new HBox(lb_title, actualizar);
        hb_title.setAlignment(Pos.CENTER);
        hb_title.setPadding(new Insets(15)); 
        
        vbos_ranks = new VBox();
        vbos_ranks.setAlignment(Pos.CENTER);
        gp_ranking = new GridPane();       
        
        cargarRanking(modelo_fecha_comida.cargarRanking());
        recargarRanking();
    }
    
    private void cargarRanking(Map<String, String> ranked){
        Map<String, String> ranking = ranked;
        
        Map<String, String> sortedByCount = ranking.entrySet()
                .stream()
                .sorted((Map.Entry.<String, String>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        
        int i=0;
        int j=0;
        for (Map.Entry<String, String> entry : sortedByCount.entrySet()) {
            gp_ranking.add(new Label(entry.getKey()),i,j);
            gp_ranking.add(new Label(entry.getValue()),i+1,j);
            j+=2;
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
        gp_ranking.setPadding(new Insets(20));
        gp_ranking.setHgap(25);
        gp_ranking.setVgap(15);
        vbos_ranks.getChildren().add(gp_ranking);
        vbos_ranks.setAlignment(Pos.CENTER);
        System.out.println("El tamaño es: "+ranking.size());        
    }
    
    private void recargarRanking(){
        actualizar.setOnMouseClicked(e->{            
            vbos_ranks.getChildren().clear();
            cargarRanking(modelo_fecha_comida.recargarRanking());  
            vbos_ranks.setAlignment(Pos.CENTER);          
        });
        
    }

    public BorderPane getRoot() {
        return root;
    }
    
    
    
}
