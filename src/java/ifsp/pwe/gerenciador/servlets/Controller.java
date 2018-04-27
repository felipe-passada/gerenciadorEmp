/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Giovani
 */
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tarefa
        String tarefa = req.getParameter("tarefa");
        
        //recebendo o metodo
        String metodo = req.getParameter("metodo");
        
        if(tarefa == null) {
            throw new IllegalArgumentException("Você esqueceu de informar a tarefa!");
        }
        
        try {
            tarefa = "ifsp.pwe.gerenciador.servlets." + tarefa;
            Class<?> classe = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) classe.newInstance();
            String pagina = null;
            
            if(metodo == null) {
                pagina = instancia.executa(req, resp);
            } else {
                Method[] declaredMethods = classe.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    String nomeMetodo = method.getName();
                    if(nomeMetodo.equals(metodo)){
                        method.setAccessible(true);
                        Object o = method.invoke(instancia, req, resp );
                        pagina = (String)o;
                    }
                } 
            }
            
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            requestDispatcher.forward(req, resp);

        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.toString());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
