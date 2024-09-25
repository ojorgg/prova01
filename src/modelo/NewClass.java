/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class NewClass {

    private static EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("prova01PU");

    private static void createQuery() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
        List<Funcionario> funcionarios = query.getResultList();

        em.close();

    }

    public static void main(String[] args) {
        System.out.println("a");

    }
}
