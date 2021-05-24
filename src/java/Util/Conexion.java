/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JUAN DAVID PACHON
 */
public class Conexion {

    /* se crean los atributos encapsulados*/
 /* por defecto es root pero se debe cambiar por seguridad*/
    private String user, password, bd, url, puerto, driver;
    private Connection conexion;

    /*metodo contructor*/
    public Conexion() {

        /*tomar valores*/ /*driver con de MYSQL*/

        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        bd = "ventavehiculos";
        puerto = "3306";
        url = "jdbc:mysql://localhost:" + puerto + "/" + bd;

        /*captura de error*/
        try {
            /*traer driver a la clase*/
            Class.forName(driver).newInstance();
            /*hago la conexion*/
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("Error de Conexion" + e.toString());
        }

    }

    public Connection obternerConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        /*agregar clauseula de sql exception y ña vuelvo nula*/
        
        conexion.close(); 
        conexion=null;
        return conexion;
        
    }
    public static void main(String[] args) {
        new Conexion();
    }

    

}
