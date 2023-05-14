package PFE.Gestion_Des_Anonces.Api.Controllers;

import PFE.Gestion_Des_Anonces.Api.Models.Ville;
import PFE.Gestion_Des_Anonces.Api.Repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleController {

    private VilleRepository Repository;

    @Autowired
    public VilleController(VilleRepository repository) {
        this.Repository = repository;
    }

    @GetMapping("/villes")
    public List<Ville> getAll(){
        return Repository.findAll();
    }

}
