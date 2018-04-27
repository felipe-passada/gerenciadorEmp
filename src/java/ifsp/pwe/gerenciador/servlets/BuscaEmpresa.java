/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;
import ifsp.pwe.gerenciador.beans.Empresa;
import ifsp.pwe.gerenciador.dao.EmpresaDAO;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class BuscaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = null;
        try {
            empresas = new EmpresaDAO().buscaSimilar(filtro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("empresas", empresas);
        return "/WEB-INF/paginas/busca.jsp";
    }

    @Override
    public Boolean verificaPermissao() {
        return false;
    }
}
