/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;
import ModeloVO.CategoriaVO;
import ModeloVO.VehiculoVO;
import Util.Conexion;
import Util.Crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JUAN DAVID PACHON
 */
public class CategoriaDAO extends Conexion {
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
        
    //* los list no pasan por el controlador*//
        public ArrayList<CategoriaVO> listar(){ 
        
        ArrayList<CategoriaVO>listaCategorias = new ArrayList<>();
        
        try {
            conexion = this.obternerConexion();
            sql="select * from categoria";
            puente=conexion.prepareStatement(sql); 
            mensajero= puente.executeQuery();
            while(mensajero.next()){
                
             CategoriaVO catVO = new CategoriaVO(mensajero.getString(1), mensajero.getString(2));
                
                listaCategorias.add(catVO);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, sql);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, sql);
            }
        
        }
        return listaCategorias;
        }
    
}
