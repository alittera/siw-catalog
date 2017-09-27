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

        Fornitore f1 = new Fornitore("Fornitore 1", "Via viale 11", "service@for.com", "+00 123456789");
        Fornitore f2 = new Fornitore("Fornitore 2", "Via viale 22", "service@for.com", "+00 123456789") ;
        Fornitore f3 = new Fornitore("Fornitore 3", "Via viale 33", "service@for.com", "+00 123456789") ;
        Fornitore f4 = new Fornitore("Fornitore 4", "Via viale 44", "service@for.com", "+00 123456789") ;
        Fornitore f5 = new Fornitore("Fornitore 5", "Via viale 55", "service@for.com", "+00 123456789") ;
        Fornitore f6 = new Fornitore("Fornitore 6", "Via viale 66", "service@for.com", "+00 123456789") ;


        fornitoreService.save(f1); fornitoreService.save(f2); fornitoreService.save(f3);fornitoreService.save(f4);fornitoreService.save(f5);fornitoreService.save(f6);


        Prodotto p1 = new Prodotto("Benzina", new ArrayList<Fornitore> () {{add(f1);add(f2);add(f3);}}, "\n" +
                "Senza Piombo",10);
        Prodotto p2 = new Prodotto("Farina ", new ArrayList<Fornitore> () {{add(f1);add(f2);add(f3);add(f4);add(f5);add(f6);}}, "Tipo 00 macinata a pietra",2);
        Prodotto p3 = new Prodotto("Metallo sfudo", new ArrayList<Fornitore> () {{add(f1);}}, "10Kg sbarra ferro dolce",40);

        prodottoService.save(p1); prodottoService.save(p2); prodottoService.save(p3);


        f1.setProdotti(new ArrayList<Prodotto> () {{add(p1);add(p2);}});
        f2.setProdotti(new ArrayList<Prodotto> () {{add(p1);add(p2);}});
        f3.setProdotti(new ArrayList<Prodotto> () {{add(p1);add(p2);}});
        f4.setProdotti(new ArrayList<Prodotto> () {{add(p2);}});
        f5.setProdotti(new ArrayList<Prodotto> () {{add(p2);}});
        f6.setProdotti(new ArrayList<Prodotto> () {{add(p2);}});

        fornitoreService.save(f1); fornitoreService.save(f2); fornitoreService.save(f3);fornitoreService.save(f4);fornitoreService.save(f5);fornitoreService.save(f6);


    }

}