package it.uniroma3.catalog.controller;

        import it.uniroma3.catalog.models.Prodotto;
        import it.uniroma3.catalog.service.FornitoreService;
        import it.uniroma3.catalog.service.ProdottoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        //import sun.jvm.hotspot.debugger.win32.coff.OptionalHeaderWindowsSpecificFields;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by alittera on 15/09/2017.
 */

@Controller
public class IndexController {

    @Autowired
    private FornitoreService fornitoreService;

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping(value={"/", "/index","/home"})
    public String home(Model model)
    {

        List <Prodotto> oldd = new ArrayList<Prodotto>();

        model.addAttribute("prodotti", prodottoService.get());
        return "index";
    }

    @GetMapping("/cerca")
    public String homeWithSearch(Model model)
    {

        List<Prodotto> allProdotti=prodottoService.get();

        /*Ricerca
        List<Prodotto> selectedProdotti= new ArrayList<>();
        for(int i=0; i<allProdotti.size(); i++)

                selectedProdotti.add(allProdotti.get(i));
        */
        model.addAttribute("prodotti", allProdotti);


        return "index";
    }

    @GetMapping("/login")
    public String redirect2SpringSecurityLogin(){ return "login"; }

    //@PostMapping("/logout")
    //public String redirect2SpringSecurityLogout(){ return "logout"; }
}