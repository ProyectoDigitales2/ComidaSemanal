/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Comida;
import Modelo.Ingrediente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Rogencio
 */
public class VistaAgregarComida {
    private BorderPane root;
    private Label lb_title, lb_comida, lb_categoria, lb_temperatura, lb_ingrediente;
    private ComboBox cb_categoria, cb_temperatura;
    private TextField tf_comida, tf_INGREDIENTE;
    private TableView tb_ingrediente;
    private Button btn_agregar, btn_eliminar, btn_agregarcomida;
    
    private String txt_comida="";
    
    
    private Categoria modeloCategoria;
    private Ingrediente modeloIngrediente;
    private Comida modeloComida;
    
    private ObservableList<String> cargarIngredientes;
    private ObservableList<String> cargarComida ;
    private ObservableList<Categoria> cargarCategoria;
    
    public VistaAgregarComida() {
        modeloCategoria= new Categoria();
        modeloIngrediente = new Ingrediente();
        modeloComida = new Comida();
        
        cargarCategoria=modeloCategoria.cargarCategoria();
        cargarIngredientes = modeloIngrediente.cargarNombreIngredientes();
        cargarComida = modeloComida.cargarNombreComida();
        inicializar();
        Top();
        Center();
        Right();
        setTamanio(200);
    }
    
    private void inicializar(){
        root = new BorderPane();
        root.getStylesheets().add("/Recursos/Estilo/style1.css"); 
        root.setStyle("-fx-background-color: CCFFFF");
        tb_ingrediente = new TableView();
        ObservableList<String> temperatura = FXCollections.observableArrayList( "CALIENTE", "FRIO" );
        root.setPadding(new Insets(10));
        lb_title=new Label("PLATO");lb_comida=new Label("COMIDA");lb_categoria=new Label("CATEGORIA");lb_temperatura=new Label("TEMPERATURA");lb_ingrediente=new Label("INGREDIENTES");
        lb_title.setId("tituloCentral");
        lb_comida.setId("subtitulo");lb_categoria.setId("subtitulo");lb_temperatura.setId("subtitulo");lb_ingrediente.setId("subtitulo");
        tf_comida = new TextField(); tf_INGREDIENTE= new TextField();        
        cb_categoria= new ComboBox();
        cb_categoria.setItems(cargarCategoria);
        cb_categoria.getSelectionModel().selectFirst();
        
        cb_temperatura= new ComboBox();
        cb_temperatura.setItems(temperatura);
        cb_temperatura.getSelectionModel().selectFirst();
        
        TextFields.bindAutoCompletion(tf_INGREDIENTE, cargarIngredientes);
        TextFields.bindAutoCompletion(tf_comida, cargarComida);
        btn_agregar = new Button("AGREGAR"); btn_eliminar= new Button("ELIMINAR"); btn_agregarcomida = new Button("GUARDAR");
    }
    
    private void Top(){
        VBox vb = new VBox(15,lb_title);
        vb.setPadding(new Insets(15));
        vb.setAlignment(Pos.CENTER);
        root.setTop(vb);
    }
    private void Center(){
        VBox vb = new VBox(10,lb_comida,tf_comida, lb_categoria,cb_categoria,lb_temperatura,cb_temperatura, btn_agregarcomida);
        tf_comida.setPromptText("Nombre de la comida");
        vb.setAlignment(Pos.CENTER_RIGHT);
        vb.setPadding(new Insets(15));
        root.setCenter(vb);        
    }
    
    private void Right(){
        VBox vb = new VBox(15, tf_INGREDIENTE, btn_agregar, btn_eliminar); 
        tf_INGREDIENTE.setPromptText("Nombre del Ingrediente");
        vb.setAlignment(Pos.CENTER);
        HBox hb = new HBox(10,tb_ingrediente, vb);
        VBox vb1 = new VBox(10, lb_ingrediente, hb);
        vb1.setAlignment(Pos.CENTER);
        root.setRight(vb1);
    }
    
    private void setTamanio(int size){
        tf_comida.setPrefWidth(size);
        tf_INGREDIENTE.setPrefWidth(size);
        cb_categoria.setPrefWidth(size);
        cb_temperatura.setPrefWidth(size);
        btn_agregar.setPrefWidth(size);
        btn_agregarcomida.setPrefWidth(size);
        btn_eliminar.setPrefWidth(size);
        tb_ingrediente.setPrefSize(175, 300);
    }

    public Parent getRoot() {
        return root;
    }
    
    
    
    
}
