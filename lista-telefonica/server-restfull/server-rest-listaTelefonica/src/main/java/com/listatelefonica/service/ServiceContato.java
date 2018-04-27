package com.listatelefonica.service;

import com.listatelefonica.domain.Contato;
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
public class ServiceContato {

    @PersistenceContext
    private EntityManager em;

    public void adicionarContato(Contato contato) {
        em.persist(contato);
    }

    public List<Contato> listarContatos() {
        return em.createQuery("SELECT c FROM Contato c", Contato.class).getResultList();
    }

    public Contato buscarContato(int id) {
        return em.find(Contato.class, id);
    }

    public void removerContato(int id) {
        Contato find = em.find(Contato.class, id);
        em.remove(find);
    }

    public void atualizarContato(int id, Contato contato) {
        contato.setId(id);
        em.merge(contato);
    }
}
