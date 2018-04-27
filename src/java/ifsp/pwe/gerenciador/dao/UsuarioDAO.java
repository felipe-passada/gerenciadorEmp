/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.dao;

import ifsp.pwe.gerenciador.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.BooleanUtils;

/**
 *
 * @author Giovani
 */
public class UsuarioDAO {

    private static Connection connection;
    
    public UsuarioDAO() throws ClassNotFoundException{
        UsuarioDAO.connection = ConnectionFactory.getConnection();
    }
    
    
    
    public Usuario buscaPorEmailESenha(String email, String senha) throws SQLException {
        if (email == null || senha == null){
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE email = '" + email + "'");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario(rs.getString("email"), rs.getString("senha"), BooleanUtils.toBoolean(rs.getInt("admin")));
            if (usuario.getSenha().equals(senha))
                return usuario;
        }  
        rs.close();
        stmt.close();
        return null;
    }
}
