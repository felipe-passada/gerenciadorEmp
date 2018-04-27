/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.dao;

import ifsp.pwe.gerenciador.beans.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Giovani
 */
public class EmpresaDAO {
    
    private static Connection connection;
    
    public EmpresaDAO() throws ClassNotFoundException{
        EmpresaDAO.connection = new ConnectionFactory().getConnection();
    }
    
    public Collection<Empresa> buscaSimilar(String filtro) throws SQLException {
        List<Empresa> similares = new ArrayList<>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM empresa WHERE nome LIKE '%" + filtro + "%'");
        if (filtro == null){
            stmt = this.connection.prepareStatement("select * from empresa");
        }
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nomeDaEmpresa = rs.getString("nome");
            Empresa empresa = new Empresa(nomeDaEmpresa);
            empresa.setId(id);
            similares.add(empresa);
        }
        rs.close();
        stmt.close();
        return similares;
    }
    
    public static void adiciona(Empresa empresa) throws SQLException {
        String sql = "insert into empresa (id, nome) values (?,?)";
        System.out.println("O sql é " + sql);
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, geraChave());
        stmt.setString(2, empresa.getNome());
        stmt.execute();
        stmt.close();
    }
    
    private static int geraChave() throws SQLException{
          String sql = "select * from empresa";
          PreparedStatement stmt = connection.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery();
          int chave = 0;
          while(rs.next())
          {
              chave++;
          }
          return chave + 1;
    }
        
}
