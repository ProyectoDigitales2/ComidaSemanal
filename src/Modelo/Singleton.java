/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogencio
 */
public class Singleton {
    private static Singleton dbConnection;
    private Connection connection;
    
    private final String url = "jdbc:mysql://localhost:3306/comida?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";

    private final String pass = "1997ra"; 
    
    private static final Logger LOGGER = Logger.getLogger("DBConnection Logger");
    
    private Singleton(){   
    }
    
    public static Singleton getInstance(){        
        if(dbConnection == null)            
            dbConnection = new Singleton();        
        return dbConnection;
    }
    
    
    
    public Connection getConnection() {        
        return connection;        
    }
    
    public void setConnection(Connection connexion) {
        this.connection = connexion;
    }
    
    /**
     * Método de tipo void para establecer connection con la Base de datos
     */
    public void conectar() {        
        //LOGGER.log(Level.INFO, "Establishing the database connection...");        
        try{
            this.connection = DriverManager.getConnection(url, user, pass);
            //LOGGER.log(Level.INFO, "¡The database connection was established successfully!");
            
        } catch(Exception e){            
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    
    /**
     * Método para cerrar la connection a la base de datos, no retorna nada
     */
    public void desconectar(){        
	try {
            connection.close();
            
	} catch (SQLException e) {            
            LOGGER.log(Level.SEVERE, e.getMessage());
	}
    }
    
    

}
