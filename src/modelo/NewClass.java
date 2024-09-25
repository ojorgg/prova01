/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
public class NewClass {

    private static EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("prova01PU");

    public static void main(String[] args) {

        createQuery();
        adicionarFuncionario("Jorge", "Jorgg", 100);
        adicionarFuncionario("Jorge", "Jorgg", 100);
        adicionarGerente("Jorge", "Jorgg1", 100, 20);
        adicionarGerente("Jorge", "Jorgg1", 100, 20);
        adicionarGerente("Jorge", "Jorgg2", 100, 20);
        adicionarComissionados("Jorge", "Jorgg4", 100, 20);
        adicionarComissionados("Jorge", "Jorgg4", 100, 20);

        // aumentaSalario(10); - nao funcionou
    }

    public boolean existsLogin(String login) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createNamedQuery(
                "Funcionario.FindByLogin",
                Funcionario.class);
        query.setParameter("login", login);

        try {
            Funcionario f = query.getSingleResult();
            em.close();
            return true;
        } catch (NoResultException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void adicionarFuncionario(String nome, String login, double slario) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createNamedQuery(
                "Funcionario.FindByLogin",
                Funcionario.class);
        query.setParameter("login", login);

        try {
            Funcionario f = query.getSingleResult();
            em.close();
            System.out.println("login existente");
        } catch (NoResultException e) {
            Funcionario v = new Funcionario();
            v.setLogin(login);
            v.setNome(nome);
            v.setSalario(slario);

            em.getTransaction().begin();
            em.persist(v);

            //Finaliza a transação
            em.getTransaction().commit();
            em.close();

        }

//        boolean retorno = this.existsLogin(login);
//        if (!retorno) {
        //Inicia uma transação
        //Gravar o objeto (veiculo1) no banco de dados (INSERT)
//        }
        //Gerencia a entidade (transação, CRUD)        
    }

    public static void adicionarGerente(String nome, String login, double salario, double porcentagem) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createNamedQuery(
                "Funcionario.FindByLogin",
                Funcionario.class);
        query.setParameter("login", login);

        try {
            Funcionario f = query.getSingleResult();
            em.close();
            System.out.println("login existente");
        } catch (NoResultException e) {
            em.getTransaction().begin();

            //Gravar o objeto (veiculo1) no banco de dados (INSERT)
            Gerente v = new Gerente(nome, login, salario, porcentagem);

            em.persist(v);

            //Finaliza a transação
            em.getTransaction().commit();
            em.close();

        }

//        boolean retorno = this.existsLogin(login);
//        if (!retorno) {
        //Inicia uma transação
//        }
        //Gerencia a entidade (transação, CRUD)        
    }

    public static void adicionarComissionados(String nome, String login, double salario, double comissao) {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createNamedQuery(
                "Funcionario.FindByLogin",
                Funcionario.class);
        query.setParameter("login", login);

        try {
            Funcionario f = query.getSingleResult();
            em.close();
            System.out.println("login existente");
        } catch (NoResultException e) {
            em.getTransaction().begin();

            //Gravar o objeto (veiculo1) no banco de dados (INSERT)
            Comissionados v = new Comissionados(nome, login, salario, comissao);

            em.persist(v);

            //Finaliza a transação
            em.getTransaction().commit();
            em.close();

        }

//        boolean retorno = this.existsLogin(login);
//        if (!retorno) {
        //Inicia uma transação
//        }
        //Gerencia a entidade (transação, CRUD)        
    }

    private static void createQuery() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Funcionario> query = em.createQuery("SELECT v FROM Funcionario v", Funcionario.class);
        List<Funcionario> carros = query.getResultList();

        em.close();
    }

    private static void aumentaSalario(double valor) {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("Funcionario.UpdateSalario",
                Funcionario.class);
        query.setParameter("aumento", valor);

        query.executeUpdate();

        em.close();
    }

}
