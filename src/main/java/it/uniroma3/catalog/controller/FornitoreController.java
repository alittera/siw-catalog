package it.uniroma3.catalog.controller;

import it.uniroma3.catalog.models.Fornitore;
import it.uniroma3.catalog.service.FornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by alittera on 20/09/2017.
 */

@Controller
public class FornitoreController
{
    @Autowired
    private FornitoreService fornitoreService;

    @GetMapping("/fornitore/{id}")
    public String visualizzaDettagliFornitore(@PathVariable long id, Model model)
    {
        Fornitore fornitore = fornitoreService.find(id);
        model.addAttribute("prodotti", fornitore.getProdotti());
        model.addAttribute("fornitore", fornitore);
        return "dettagliFornitore";
    }

    @GetMapping("/fornitori/")
    public String visualizzaFornitori( Model model)
    {
        List<Fornitore> fornitori = fornitoreService.get();
        model.addAttribute("fornitori", fornitori);
        return "fornitori";
    }
}
