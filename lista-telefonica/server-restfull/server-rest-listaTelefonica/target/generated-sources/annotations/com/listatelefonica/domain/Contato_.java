package com.listatelefonica.domain;

import com.listatelefonica.domain.Operadora;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-26T13:36:08")
@StaticMetamodel(Contato.class)
public class Contato_ { 

    public static volatile SingularAttribute<Contato, String> telefone;
    public static volatile SingularAttribute<Contato, Date> data;
    public static volatile SingularAttribute<Contato, String> nome;
    public static volatile SingularAttribute<Contato, Integer> id;
    public static volatile SingularAttribute<Contato, Operadora> operadora;

}