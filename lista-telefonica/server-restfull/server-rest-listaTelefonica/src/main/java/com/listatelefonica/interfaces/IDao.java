package com.listatelefonica.interfaces;

import com.listatelefonica.domain.Contato;
import com.listatelefonica.domain.Operadora;

/**
 *
 * @author Jozimar
 */
public interface IDao {

    void cadastrarContato(Contato contato);

    void cadastrarOperadora(Operadora operadora);
}
