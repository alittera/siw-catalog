package it.uniroma3.catalog;

/**
 * Created by alittera on 20/09/2017.
 */
import it.uniroma3.catalog.models.Fornitore;
import it.uniroma3.catalog.models.Prodotto;
import it.uniroma3.catalog.service.FornitoreService;
import it.uniroma3.catalog.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    FornitoreService fornitoreService;

    @Autowired
    ProdottoService prodottoService;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event)
    {

        Fornitore f1 = new Fornitore("Fornitore 1", "Via xiosdd 11", "service@toshiba.com", "+23 33467654289");
        Fornitore f2 = new Fornitore("Fornitore 2", "Via xiosdd 22", "service@toshiba.com", "+23 33467654289");
        Fornitore f3 = new Fornitore("Fornitore 3", "Via xiosdd 33", "service@toshiba.com", "+23 33467654289");


        fornitoreService.save(f1); fornitoreService.save(f2); fornitoreService.save(f3);


        Prodotto p1 = new Prodotto("Prodotto 1", new ArrayList<Fornitore> () {{add(f1);add(f2);add(f3);}}, "Descrizione lorem",1);
        Prodotto p2 = new Prodotto("Prodotto 2", new ArrayList<Fornitore> () {{add(f2);add(f1);}}, "Descrizione lorem",2);
        Prodotto p3 = new Prodotto("Prodotto 3", new ArrayList<Fornitore> () {{add(f2);add(f1);}}, "Descrizione lorem",3);

        prodottoService.save(p1); prodottoService.save(p2); prodottoService.save(p3);


        f1.setProdotti(new ArrayList<Prodotto> () {{add(p1);add(p2);}});
        f2.setProdotti(new ArrayList<Prodotto> () {{add(p1);add(p2);}});
        f3.setProdotti(new ArrayList<Prodotto> () {{add(p1);}});

        fornitoreService.save(f1); fornitoreService.save(f2); fornitoreService.save(f3);


    }

}