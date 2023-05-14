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
    }
}
