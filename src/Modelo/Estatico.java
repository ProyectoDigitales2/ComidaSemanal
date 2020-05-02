/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Rogencio
 */
public class Estatico {
    protected static final Singleton CONNECTION = Singleton.getInstance();

    public static void ventanaEmergente(FXMLLoader ventanaEmergente, Parent root, String title){
        try {
            Parent root1= (Parent) ventanaEmergente.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.initOwner(root.getScene().getWindow() );            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Estatico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ShowWindow(Scene scene, String title, String url, Parent root) {    
        Stage st= new Stage();
        st.setScene(scene);
        st.setTitle(title);
        st.initModality(Modality.WINDOW_MODAL);
        st.getIcons().add(new Image(url));
        st.initOwner(root.getScene().getWindow() );
        st.showAndWait();
    }
    
    public static void alertas_warning(String title, String Texto){
        Notifications.create().position(Pos.CENTER)
              .title(title)
              .text(Texto)
              .showWarning();        
    }
    
    public static void alertas_information(String title, String Texto, Pos pos){
        Notifications.create().position(pos)
              .title(title)
              .text(Texto)
              .showInformation();
    }


    public static void limiTextField(TextField tf, int limit) {
        tf.lengthProperty().addListener(new ChangeListener <Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Check if the new character is greater than LIMIT
                    if (tf.getText().length() >= limit) {
                        // if it's 11th character then just setText to previous one
                        tf.setText(tf.getText().substring(0, limit));
                    }
                }
            }
        });
    } 
    public static void obtenerTablaDinamica( int idArgumento, String Query, TableView table, String idTable){
        ObservableList<ObservableList> ref = FXCollections.observableArrayList();
        try{
            CONNECTION.conectar();
            PreparedStatement ps = CONNECTION.getConnection().prepareStatement(Query);
            if(idArgumento!= -1)
                ps.setInt(1,idArgumento);            
            ResultSet rs = ps.executeQuery();   
            
            table.getColumns().clear();
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setEditable(true);
                if(i!=0){
                    col.setMinWidth(175);
                }
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {

                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }
                });

                table.getColumns().addAll(col);
                table.setId(idTable);
            }
            
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if(rs.getString(i)==null){row.add("---");}
                    else{
                        row.add(rs.getString(i));
                    }                    
                }
                ref.add(row);

            }
            table.setItems(ref);
        }catch (SQLException e) {
            System.out.println("Error on Building Table: "+e.getMessage());
        }
    }
    
    
    
}
