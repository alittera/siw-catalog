package it.uniroma3.catalog.service;

import it.uniroma3.catalog.models.Fornitore;
import it.uniroma3.catalog.repository.FornitoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alittera on 15/09/2017.
 */

@Service
public class FornitoreService {

    @Autowired
    private FornitoreRepository repo;

    public List<Fornitore> get() { return repo.findAll(); }

    public Fornitore find(long Id) { return repo.findFornitoreByIdEquals(Id); }

    public Fornitore save(Fornitore fornitore){ return repo.save(fornitore); }

    public void remove(Fornitore fornitore){ repo.delete(fornitore);}
}
