/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Ingrediente.CONNECTION;
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
public class Comida {
    private int id_comida;
    private String nombre;
    private String temperatura;
    private String catego;
    private Categoria categoria;

    private final String obtenerComida="SELECT * from comida c, categoria ca where c.id_categoria=ca.id_categoria order by c.nombre";
    protected static final Singleton CONNECTION = Singleton.getInstance();
    
    private final String guardarComida = "{call   agregarComida (?,?,?)}";
    private final String eliminarComida = "{call   eliminarComida (?)}";

    public Comida() {
    }

    public Comida(int id_comida, String nombre, String temperatura, Categoria categoria) {
        this.id_comida = id_comida;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.categoria = categoria;
    }

    public Comida(int id_comida, String nombre, String temperatura, String catego) {
        this.id_comida = id_comida;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.catego = catego;
    }
    
    

    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCatego() {
        return catego;
    }

    public void setCatego(String catego) {
        this.catego = catego;
    }
    
    
    
    public ObservableList<Comida> cargarComida(){
       ObservableList <Comida> listaComida = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            Statement s = CONNECTION.getConnection().createStatement();
            ResultSet rs = s.executeQuery (obtenerComida);            
            while (rs.next()) {           
                Categoria cat= new Categoria(
                        rs.getString("categoria"));
                listaComida.add(new Comida(
                            rs.getInt("id_comida"),
                            rs.getString("nombre"),
                            rs.getString("temperatura"),
                            cat.getCategoria()));
            }
        } catch (SQLException  ex) {
            System.out.println(ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return listaComida;
    }
    
    public ObservableList<String> cargarNombreComida(){
       ObservableList <String> listaComida = FXCollections.observableArrayList ();
        try {
            CONNECTION.conectar();
            Statement s = CONNECTION.getConnection().createStatement();
            ResultSet rs = s.executeQuery (obtenerComida);            
            while (rs.next()) { 
                listaComida.add(rs.getString("nombre"));
            }
        } catch (SQLException  ex) {
            System.out.println(ex.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
        return listaComida;
    }

    
    public boolean guardarComida(String comida, String tempt, String categ){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(guardarComida);
            sp.setString(1, comida);
            sp.setString(2, tempt);
            sp.setString(3, categ);
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
    
    public boolean eliminarComida(String comida){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(eliminarComida);
            sp.setString(1, comida);
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
