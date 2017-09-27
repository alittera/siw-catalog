package it.uniroma3.catalog;

import it.uniroma3.catalog.models.Fornitore;
import it.uniroma3.catalog.models.Prodotto;
import it.uniroma3.catalog.service.FornitoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by alittera on 16/09/2017.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private FornitoreService service;
    Fornitore fornitore;
    List<Prodotto> prodotti;


    @Before
    public void setup()
    {

        fornitore=service.save(fornitore);
    }

    @Test
    public void ExistTest()
    {
        List<Fornitore> retrievedList=service.get();
        assertTrue(retrievedList.size()==1);
    }

    @Test
    public void RetrieveTest()
    {
        List<Fornitore> retrievedList=service.get();
        assertEquals(fornitore, retrievedList.get(0));
    }
}
