/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import ifsp.pwe.gerenciador.beans.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class Filtro implements Filter {

 @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        Usuario usuario =  getUsuario(req);
        if(usuario == null)
            System.out.println("usuario deslogado acessando a uri " + req.getRequestURI());
        else
            System.out.println("usuario " + usuario.getEmail() + " acessando a uri " + req.getRequestURI());
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
    }

    private Usuario getUsuario(HttpServletRequest req) {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if(usuario==null) 
            return null;
        else
            return usuario;
    }

}
