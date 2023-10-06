package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Compra;

public class CompraJPAController {
	private EntityManagerFactory emf;

    public CompraJPAController() {
        emf = Persistence.createEntityManagerFactory("unilins-jpa");
    }

    public void create(Compra compra) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(compra);
        et.commit();
        em.close();
    }

    public void edit(Compra compra) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(compra);
        et.commit();
        em.close();
    }

    public void destroy(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Compra compra = em.find(Compra.class, id);
        if (compra != null) {
            em.remove(compra);
        }
        et.commit();
        em.close();
    }

    public List<Compra> findAll() {
    	EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Compra c", Compra.class);
        List<Compra> compras = query.getResultList();
        em.close();
        return compras;
    }

    public Compra findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Compra compra = em.find(Compra.class, id);
        em.close();
        return compra;
    }
}
