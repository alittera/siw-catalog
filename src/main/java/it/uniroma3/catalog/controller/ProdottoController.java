package it.uniroma3.catalog.controller;

import it.uniroma3.catalog.models.Dummy;
import it.uniroma3.catalog.models.Fornitore;
import it.uniroma3.catalog.models.Prodotto;
import it.uniroma3.catalog.service.FornitoreService;
import it.uniroma3.catalog.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alittera on 22/09/2017.
 */

@Controller
public class ProdottoController {
    @Autowired
    FornitoreService fornitoreService;

    @Autowired
    ProdottoService prodottoService;

    @GetMapping("/protected/aggiungiProdotto")
    public String aggiungiProdotto(Model model) {
        model.addAttribute("fornitori", fornitoreService.get());
        model.addAttribute("prodotto", new Prodotto());
        return "formProdottoSave";
    }

    @PostMapping("/protected/aggiungiProdotto")
    public String salvaProdotto(@RequestParam("file") MultipartFile file, Model model, @Valid Prodotto prodotto, BindingResult bindingResult, @ModelAttribute("fornitori") ArrayList<Fornitore> fornitori) {
        if (bindingResult.hasErrors() || file.isEmpty())
        {
            if(file.isEmpty())
                model.addAttribute("immaginegNonInserita",true);
            model.addAttribute("fornitori", fornitoreService.get());
            return "formProdottoSave";
        }

        for(int i=0; i<fornitori.size(); i++) {
            fornitori.get(i).getProdotti().add(prodotto);
        }

        Prodotto prodottoSalvata=prodottoService.save(prodotto, file);
        return "redirect:/prodotto/"+prodottoSalvata.getId()+"";
    }

    @GetMapping("/protected/eliminaProdotto/{id}")
    public String cancellaProdotto(@PathVariable long id, Model model) {
        Prodotto oldprodotto = prodottoService.find(id);
        List <Fornitore> old_fornitori = oldprodotto.getFornitori();
        for (Fornitore f : oldprodotto.getFornitori()) {
            f.getProdotti().remove(oldprodotto);
            fornitoreService.save( f);
        }
        prodottoService.removeThroughId(id);
        model.addAttribute("prodotti", prodottoService.get());
        return "redirect:/home";
    }

    @GetMapping("/protected/modificaProdotto/{id}")
    public String modificaProdotto(@PathVariable long id, Model model)
    {
        model.addAttribute("prodotto", prodottoService.find(id));
        model.addAttribute("fornitori", fornitoreService.get());

        return "formProdottoUpdate";
    }

    @PostMapping("/protected/modificaProdotto")
    public String salvaModificaProdotto(@RequestParam("file") MultipartFile file, Model model, @Valid Prodotto prodotto, BindingResult bindingResult, @ModelAttribute("fornitori") ArrayList<Fornitore> fornitori)
    {
        model.addAttribute("fornitori", fornitoreService.get());
        if (bindingResult.hasErrors() || file.isEmpty())
        {
            if(file.isEmpty())
                model.addAttribute("immaginegNonInserita",true);

            return "formProdottoUpdate";
        }

        Prodotto oldprodotto = prodottoService.find(prodotto.getId());
        List <Fornitore> old_fornitori = oldprodotto.getFornitori();
        for (Fornitore f : oldprodotto.getFornitori()) {
            f.getProdotti().remove(oldprodotto);
            fornitoreService.save( f);
        }
        for(int i=0; i<fornitori.size(); i++) {
            fornitori.get(i).getProdotti().add(prodotto);
        }

        Prodotto prodottoSalvata=prodottoService.save(prodotto, file);

        return "redirect:/prodotto/"+prodottoSalvata.getId()+"";
    }

    @GetMapping("/prodotto/{id}")
    public String dettagliProdotto(@PathVariable long id, Model model)
    {
        Prodotto prodotto = prodottoService.find(id);
        List<Fornitore> fornitori = prodotto.getFornitori();

        model.addAttribute("prodotto", prodotto);
        model.addAttribute("fornitori", fornitori);
        return "dettagliProdotto";
    }

    @GetMapping("/prodotti/")
    public String dettagliProdotto(Model model)
    {

        model.addAttribute("prodotti", prodottoService.get());
        return "prodotti";
    }





}