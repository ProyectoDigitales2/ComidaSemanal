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
   public static void main(String[] args) { 
      Jedis jedis = new Jedis("localhost",6379);
      System.out.println("ping!: " + jedis.ping()); 
   } 
}