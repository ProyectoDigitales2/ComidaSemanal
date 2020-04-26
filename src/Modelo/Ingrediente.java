/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rogencio
 */
public class Ingrediente {
    protected int id_ingrediente;
    protected String nombre;
    
    protected static final Singleton CONNECTION = Singleton.getInstance();

    private final String obtenerIngredientes = "select * from ingrediente";
    private final String guardarIngredientes = "{call   agregarIngrediente (?)}";
    private final String modificarIngredientes = "{call   modificarIngrediente (?)}";

    public Ingrediente() {
    }
    
    public Ingrediente(int id_ingrediente, String nombre) {
        this.id_ingrediente = id_ingrediente;
        this.nombre = nombre;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ObservableList<Ingrediente> cargarIngredientes(){
       ObservableList <Ingrediente> listaIngrediente = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            Statement s = CONNECTION.getConnection().createStatement();
            ResultSet rs = s.executeQuery (obtenerIngredientes);            
            while (rs.next()) {                
                listaIngrediente.add(new Ingrediente(
                            rs.getInt("id_ingrediente"),
                            rs.getString("nombre")));
            }
        } catch (SQLException  ex) {
            System.out.println(ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return listaIngrediente;
    }
    
    public ObservableList<String> cargarNombreIngredientes(){
       ObservableList <String> listaIngrediente = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            Statement s = CONNECTION.getConnection().createStatement();
            ResultSet rs = s.executeQuery (obtenerIngredientes);            
            while (rs.next()) {                
                listaIngrediente.add(rs.getString("nombre"));
            }
        } catch (SQLException  ex) {
            System.out.println(ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return listaIngrediente;
    }
    
    public boolean guardarIngrediente(String ingrediente){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(guardarIngredientes);
            sp.setString(1, ingrediente);
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
    public boolean modificarIngrediente(String ingrediente){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(modificarIngredientes);
            sp.setString(1, ingrediente);
            sp.execute();
            sp.close();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            CONNECTION.desconectar();
        }
        return false;
    }
    
}
