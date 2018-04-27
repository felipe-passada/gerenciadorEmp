/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.beans;

/**
 *
 * @author Giovani
 */
public class Usuario {

    private String email;
    private String senha;
    private Boolean admin;

    public Usuario(String email, String senha, Boolean admin) {
        this.email = email;
        this.senha = senha;
        this.admin = admin;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isAdmin() {
        return admin;
    }
}
