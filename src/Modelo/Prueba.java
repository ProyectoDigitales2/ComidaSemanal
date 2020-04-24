/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rogencio
 */
public class Prueba {
    public static void main(String[] args) throws SQLException {
        Singleton CONNECTION = Singleton.getInstance();
        CONNECTION.conectar();
        System.out.println("Prueba");
        Statement s = CONNECTION.getConnection().createStatement();
        ResultSet rs = s.executeQuery ("select * from ingrediente");
        while (rs.next())
            {
               System.out.println("id="+rs.getObject("id_ingrediente")+
                       "nombre="+rs.getObject("nombre"));
            }
        CONNECTION.desconectar();
    }
}
