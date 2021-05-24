/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloVO.VehiculoVO;
import Util.Conexion;
import Util.Crud;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN DAVID PACHON
 */
public class VehiculoDAO  extends Conexion implements Crud  {
    
    //* Declarar Atributos
     private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    
    private boolean operacion= false;
    private String sql;
    
   // declarar variables para resibirlas del VO y se inicializan en vacio 
    private String vehPlaca="", datId="",catId="",vehModelo="",vehMarca="",vehEstado="",vehPrecio="";
    
    public VehiculoDAO(VehiculoVO  vehVO){
        super();
        try {
            conexion=this. obternerConexion();
            
            vehPlaca=vehVO.getVehPlaca();
            datId=vehVO.getDatId();
            catId=vehVO.getCatId();
            vehModelo=vehVO.getVehModelo();
            vehMarca=vehVO.getVehMarca();
            vehEstado=vehVO.getVehEstado();
            vehPrecio=vehVO.getVehPrecio();
            
            
        }catch (Exception e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    @Override
    public boolean agregarRegistro() {
         try {
            //?? para que no sea inyetado
            sql="insert into vehiculo  values (?,?,?,?,?,?,?)";
            //preparo la sentencia
            puente=conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, datId);
            puente.setString(3,catId );
            puente.setString(4, vehModelo);
            puente.setString(5,  vehMarca);
            puente.setString(6,  vehEstado);
            puente.setString(7,  vehPrecio );
           
            //mando la sentencia
             puente.executeUpdate();
               operacion=true;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            }
        }
          return operacion; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistrto() {
             try {
            //?? para que no sea inyetado
            sql="update  vehiculo  set  VEHPLACA=?,)";
            //preparo la sentencia
            puente=conexion.prepareStatement(sql);
            puente.setString(1,vehPlaca);
            puente.setString(2,datId);
            puente.setString(3,catId );
            puente.setString(4,vehModelo);
            puente.setString(5,vehMarca);
            puente.setString(6,vehEstado);
            puente.setString(7,vehPrecio );
           
            //mando la sentencia
             puente.executeUpdate();
               operacion=true;
            
            
            
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            }
        }
          return operacion; //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
