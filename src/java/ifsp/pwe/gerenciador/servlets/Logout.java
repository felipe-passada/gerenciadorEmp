/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import ifsp.pwe.gerenciador.beans.Usuario;
import ifsp.pwe.gerenciador.dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Giovani
 */
public class Logout implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false); 
        req.getSession().invalidate();
        return "/WEB-INF/paginas/Logout.html";
    }
    
    public String ChamouMetodo(HttpServletRequest req, HttpServletResponse resp) {
        return "/WEB-INF/paginas/VoceChamouOMetodo.html";
    }
    
    @Override
    public Boolean verificaPermissao() {
        return false;
    }
}
