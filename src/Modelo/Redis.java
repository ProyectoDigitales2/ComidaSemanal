/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import redis.clients.jedis.Jedis;

/**
 *
 * @author Rogencio
 */
public class Redis { 
    private static Redis conexionRedis;
    private Jedis jedis;
    
    
    public static Redis getInstance(){        
        if(conexionRedis == null)            
            conexionRedis = new Redis();        
        return conexionRedis;
    }
    
    /**
     * Para conectar a Redis, debe estar activo el server.
     */
    public void conectar() {                
        try{
            this.jedis = new Jedis("localhost",6379);
            System.out.println("Conexion Jedis Correcta");
            
        } catch(Exception e){            
            System.out.println(e.getMessage());
        }
    }

    public Jedis getJedis() {
        return jedis;
    }
    
    
    
}