/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rogencio
 */
public class Categoria {
    private String categoria;
    
    private final String queryCategorias="select categoria from categoria";
    protected static final Singleton CONNECTION = Singleton.getInstance();

    public Categoria() {
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public ObservableList<Categoria> cargarCategoria(){
       ObservableList <Categoria> listaCategoria = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            Statement s = CONNECTION.getConnection().createStatement();
            ResultSet rs = s.executeQuery (queryCategorias);            
            while (rs.next()) {           
                listaCategoria.add(new Categoria(
                            rs.getString("categoria")
                ));
            }
        } catch (SQLException  ex) {
            System.out.println(ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return listaCategoria;
    }

    @Override
    public String toString() {
        return  categoria + "";
    }
    
    
    
    
}
