/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package br.com.mackenzie.util;

import br.com.mackenzie.entities.Administrator;
import br.com.mackenzie.entities.Cidade;
import br.com.mackenzie.entities.Department;
import br.com.mackenzie.entities.Estado;
import br.com.mackenzie.entities.Media;
import br.com.mackenzie.entities.SystemUser;
import br.com.mackenzie.service.CidadeFacade;
import br.com.mackenzie.service.DepartmentFacade;
import br.com.mackenzie.service.EstadoFacade;
import br.com.mackenzie.service.MediaFacade;
import br.com.mackenzie.service.SystemUserFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
public class NewServlet extends HttpServlet {
    
    @EJB
            DepartmentFacade departmentService;
    @EJB
            EstadoFacade estadoService;
    @EJB
            CidadeFacade cidadeService;
    @EJB
            SystemUserFacade systemUserService;   
    
    @EJB
    MediaFacade mediaService;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Media entity = mediaService.find(Integer.parseInt(request.getParameter("id")));
        response.setContentType("image/jpeg");//entity.getContentType()
        response.setContentLength(entity.getCoverImage().length);
        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode(entity.getCoverFileName(), "UTF-8") + "\"");
        response.getOutputStream().write(entity.getCoverImage());
    }
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    
    
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
    @Override
    public void init() throws ServletException {
        
        System.out.println("Cadastro básico");
        
        //cadastro de departamentos
        Department dp = new Department();
        dp.setId(1);
        dp.setName("DVD Blu-Ray");
        
        //cadastro de estados
        Estado estado1 = new Estado();
        estado1.setNome("São Paulo");
        Estado estado2 = new Estado();
        estado2.setNome("Rio de Janeiro");
        
        Cidade cidade1 = new Cidade();
        cidade1.setEstado(estado1);
        cidade1.setNome("São Paulo");
        
        Cidade cidade3 = new Cidade();
        cidade3.setEstado(estado1);
        cidade3.setNome("Mairiporã");
        
        Cidade cidade2 = new Cidade();
        cidade2.setEstado(estado2);
        cidade2.setNome("Rio de Janeiro");
        
        SystemUser systemUser = new Administrator();
        systemUser.setName("Administrador");
        systemUser.setUserName("admin");
        systemUser.setPassWord("admin");
        
        try{
            systemUserService.create(systemUser);
            
            estadoService.create(estado1);
            estadoService.create(estado2);
            
            cidadeService.create(cidade1);
            cidadeService.create(cidade2);
            cidadeService.create(cidade3);
            
            departmentService.create(dp);
        }catch(Exception e){
            System.err.println("Falha no cadastro básico: "+e);
        }
    }
    
    
    
}
