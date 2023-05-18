package PFE.Gestion_Des_Anonces.Api.Services;

import PFE.Gestion_Des_Anonces.Api.Models.Membre;
import PFE.Gestion_Des_Anonces.Api.Repositories.MembreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MembreService {
    private MembreRepository Repository;
    @Autowired
    public MembreService(MembreRepository repository) {
        this.Repository = repository;
    }
    public List<Membre> getMembres(){
        return Repository.findAll();
    }

    public Membre addMembre(Membre newUser) {
        Repository.save(newUser);
        return newUser;
    }
}
