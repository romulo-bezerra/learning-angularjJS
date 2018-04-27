package com.listatelefonica.service;

import com.listatelefonica.domain.Operadora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jozimar
 */
@Stateless
public class ServiceOperadora {

    @PersistenceContext
    private EntityManager em;

    public void adicionarOperadora(Operadora operadora) {
        em.persist(operadora);
    }

    public List<Operadora> listarOperadoras() {
        return em.createQuery("SELECT o FROM Operadora o", Operadora.class).getResultList();
    }

    public Operadora buscarOperadora(int id) {
        return em.find(Operadora.class, id);
    }

    public void removerOperadora(int id) {
        Operadora find = em.find(Operadora.class, id);
        em.remove(find);
    }

    public void atualizarOperadora(int id, Operadora operadora) {
        operadora.setId(id);
        em.merge(operadora);
    }
}
