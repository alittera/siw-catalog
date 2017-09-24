package it.uniroma3.catalog.repository;

import it.uniroma3.catalog.models.Fornitore;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by alittera on 22/09/2017.
 */
public interface FornitoreRepository extends CrudRepository<Fornitore, Long> {

    List<Fornitore> findAll();

    Fornitore findOne(long Id);

    void removeById (long Id);

    //Fornitore save (Fornitore fornitore);

    Fornitore findFornitoreByIdEquals(long Id);

    void delete (Fornitore fornitore);
}
