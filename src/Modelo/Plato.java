/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Comida.CONNECTION;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Rogencio
 */
public class Plato {
    private int id_ingrediente;
    private int id_comida;
    private final String agregarPlato = "{call   agregarPlato (?,?)}";

    
    public Plato() {
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public int getId_comida() {
        return id_comida;
    }

    public void setId_comida(int id_comida) {
        this.id_comida = id_comida;
    }
    
    public boolean agregarPlato(String comida, String ingrediente){
        try {
            CONNECTION.conectar();
            CallableStatement sp = CONNECTION.getConnection().prepareCall(agregarPlato);
            sp.setString(1, comida);
            sp.setString(2, ingrediente);
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
