/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Comida.CONNECTION;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author Rogencio
 */
public class Fecha_Comida {
    private int id_comida;
    private Date fecha;
    private String tipo;
    private final String agregar_fecha_comida = "{call   agregar_fecha_comida (?,?,?)}";

    public Fecha_Comida() {
    }

    
    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean agregar_fecha_comida(String comida, Date fecha, String tipo){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(agregar_fecha_comida);
            sp.setString(1, comida);
            sp.setDate(2, fecha);
            sp.setString(3, tipo);
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
