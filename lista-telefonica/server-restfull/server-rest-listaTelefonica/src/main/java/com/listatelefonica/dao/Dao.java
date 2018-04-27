package com.listatelefonica.dao;

import com.listatelefonica.domain.Contato;
import com.listatelefonica.domain.Operadora;
import com.listatelefonica.interfaces.IDao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jozimar
 */
@Stateless
@Local(IDao.class)
public class Dao implements IDao {

    @PersistenceContext(unitName = "persistencia")
    EntityManager entityManager;

    @Override
    public void cadastrarContato(Contato contato) {
        entityManager.persist(contato);
    }

    @Override
    public void cadastrarOperadora(Operadora operadora) {
        entityManager.persist(operadora);
    }
}
