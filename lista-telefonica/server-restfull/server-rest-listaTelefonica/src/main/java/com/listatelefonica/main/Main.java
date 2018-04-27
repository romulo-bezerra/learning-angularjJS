package com.listatelefonica.main;

import com.listatelefonica.domain.Contato;
import com.listatelefonica.domain.Operadora;
import com.listatelefonica.interfaces.IDao;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Jozimar
 */
@Singleton
@Startup
public class Main {

    @Inject
    private IDao dao;

    @PostConstruct
    public void init() {

        Operadora operadora1 = new Operadora("Oi", 14, "Celular");
        Operadora operadora2 = new Operadora("Vivo", 15, "Celular");
        Operadora operadora3 = new Operadora("Tim", 41, "Celular");
        Operadora operadora4 = new Operadora("CVT", 25, "Fixo");
        Operadora operadora5 = new Operadora("Embratel", 21, "Fixo");
        Contato contato1 = new Contato("Bruno", "9999-2222", new Date(), operadora1);
        Contato contato2 = new Contato("Sandra", "9999-3333", new Date(), operadora2);
        Contato contato3 = new Contato("Mariana", "9999-9999", new Date(), operadora3);
        
//        dao.cadastrarOperadora(operadora1);
//        dao.cadastrarOperadora(operadora2);
//        dao.cadastrarOperadora(operadora3);
//        dao.cadastrarOperadora(operadora4);
//        dao.cadastrarOperadora(operadora5);
//        dao.cadastrarContato(contato1);
//        dao.cadastrarContato(contato2);
//        dao.cadastrarContato(contato3);
        
    }
}
