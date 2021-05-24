/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDao.UsuarioDao;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JUAN DAVID PACHON
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       //uso del controlador
        //1. recoger los datos
        
         String usuId= request.getParameter("textId");
         String usuLogin= request.getParameter("textUsuario");
         String usuPassword= request.getParameter("textClave");
         
         //opcion alterna para identificar vista en ves de botton 
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        //2. quien tiene los datos en el sistema (VEO)
        
        UsuarioVO usuVO = new UsuarioVO(usuId,usuLogin,usuPassword);
        //3. Quien hace las operaciones (DAO) lo instancion
        UsuarioDao usuDao = new UsuarioDao(usuVO);
        
         switch(opcion){
             case 1: // agregar registro
                 if(usuDao.agregarRegistro()){
                      //* mensajes se mandan con request set
                    request.setAttribute("mensajeExito", "El usuario se registro correctamente");
                 }else {
                     request.setAttribute("mesanjeError", "el usuario no fue registrado correctamente");
                 }
                 request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
