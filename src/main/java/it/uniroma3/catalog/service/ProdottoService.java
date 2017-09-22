package it.uniroma3.catalog.service;

import it.uniroma3.catalog.models.Prodotto;
import it.uniroma3.catalog.repository.ProdottoRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by alittera on 15/09/2017.
 */

@Service
public class ProdottoService implements ServletContextAware{

    @Autowired
    private ProdottoRepository repo;


    private ServletContext servletContext;

    public List<Prodotto> get(){ return repo.findAll(); }

    //public List<Prodotto> getOrdered() { return repo.getAllByOrderByNomeAsc(); }

    public Prodotto find(long Id) { return repo.findOne(Id); }

    public Prodotto save(Prodotto prodotto) { return repo.save(prodotto); }
    
    public Prodotto save(Prodotto Prodotto, MultipartFile file) {
        Prodotto ProdottoSaved = repo.save(Prodotto);
        String nameImage = String.valueOf(Prodotto.getId());
        saveImage(nameImage, file);


        return repo.save(ProdottoSaved);

    }

    private void saveImage(String filename, MultipartFile image) {

        File file = new File(servletContext.getRealPath("/") + "/img/" + filename + ".jpg");

        System.out.println(servletContext.getRealPath("/") + "/img/" + filename + ".jpg");
        try {
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeThroughId(long Id) { repo.removeById(Id); }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
