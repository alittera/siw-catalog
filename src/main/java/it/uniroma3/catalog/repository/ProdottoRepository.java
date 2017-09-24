package it.uniroma3.catalog.repository;

import it.uniroma3.catalog.models.Prodotto;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alittera on 15/09/2017.
 */
@Transactional
public interface ProdottoRepository extends CrudRepository<Prodotto, Long> {

    List<Prodotto> findAll ();

    //List<Prodotto> getAllByOrderByNomeAsc();

    //List<Prodotto> findAllByFornitore_Id(long Id);

    Prodotto save (Prodotto prodotto);

    //Prodotto update

    void removeById (long Id);

    Prodotto findOne (long Id);

    Prodotto findProdottoByIdEquals(long Id);
}
