/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;
import ModeloVO.UsuarioVO ;
import Util.Conexion;
import Util.Crud;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JUAN DAVID PACHON
 */
public class UsuarioDao extends Conexion implements Crud {
    //*1. Declarar atributos y obejetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    private String usuId="",usuLogin="",usuPassword="";
    
    
    //2 conectarse y traer datos del veo
    // darle valor a estos 
    // los parametros para trabajar todos los metodos de Vo
    // y defino el objeto
    //Superclase
    public UsuarioDao(UsuarioVO usuVO){
        super();
        
        try {
            conexion=this.obternerConexion();
            usuId=usuVO.getUsuId();
            usuLogin=usuVO.getUsuLogin();
            usuPassword=usuVO.getUsuPassword();
            
        } catch (Exception e) {
            //logger captura lo que me esta pasando y como se comporta
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
        }
        
    
    }

    @Override
    public boolean agregarRegistro() {
        try {
            //?? para que no sea inyetado
            sql="insert into usuario (USULOGIN,USUPASSWORD) values (?,?)";
            //preparo la sentencia
            puente=conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            //mando la sentencia
            puente.executeUpdate();
            operacion=true;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            }
        }
          return operacion;
    }

    @Override
    public boolean actualizarRegistrto() {
          try {
            //?? para que no sea inyetado
            sql="update into set USULOGIN=?,USUPASSWORD=? WHERE USUID=?";
            //preparo la sentencia
            puente=conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(2, usuId);
            //mando la sentencia
            puente.executeUpdate();
            operacion=true;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
            }
        }
          return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean  iniciarSesion(String usuario, String clave){
        try {
            conexion=this.obternerConexion();
            sql="select * from  usuario WHERE  USULOGIN=? and USUPASSWORD=?";
            puente= conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero= puente.executeQuery();
            if (mensajero.next()) {
                operacion=true;
                
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,null,e);
            }
            return operacion;
        }
    }
}
