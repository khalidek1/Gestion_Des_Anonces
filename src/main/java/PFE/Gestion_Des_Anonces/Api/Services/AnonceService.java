package PFE.Gestion_Des_Anonces.Api.Services;

import PFE.Gestion_Des_Anonces.Api.Models.Anonce;
import PFE.Gestion_Des_Anonces.Api.Repositories.AnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class AnonceService {
    private AnonceRepository Repository;
    @Autowired
    public AnonceService(AnonceRepository repository) {
        this.Repository = repository;
    }
    public List<Anonce> getAnonces(){
        return Repository.findAll();
        /*Repository.findAll().stream().map(anonce->new ANONCE_DTO_SEARCH(
                anonce.getIdAnonce(),
                anonce.getSurface() ,
                anonce.getNbreSalleBain() ,
                anonce.getNbreEtages() ,
                anonce.getNbreChambres(),
                anonce.getPrix(),
                anonce.getLatitude() ,
                anonce.getLongitude() ,
                anonce.getType() ,
                anonce.getEtat(),
                anonce.getDateCreationAnonce(),
                anonce.getEmail(),
                anonce.getTelephone(),
                anonce.getNomAnonce(),
                anonce.getDescription(),
                anonce.getCategories().stream().map(categorie -> categorie.getIdCategorie()).collect(Collectors.toList()),
                anonce.getIdVille().getIdVille()
        )).collect(Collectors.toList());
        */
    }

    public void addAnonce(Anonce anonce) {
        Repository.save(anonce);
    }

}
