/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import ifsp.pwe.gerenciador.beans.Empresa;
import ifsp.pwe.gerenciador.dao.EmpresaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Empresa empresa = new Empresa(req.getParameter("empresa"));
        try {
            new EmpresaDAO().adiciona(empresa);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NovaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("empresa", empresa);
        return "/WEB-INF/paginas/adicionado.jsp";
    }

    @Override
    public Boolean verificaPermissao() {
        return true;
    }
}
