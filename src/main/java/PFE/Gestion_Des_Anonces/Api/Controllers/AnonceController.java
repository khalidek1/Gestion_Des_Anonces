package PFE.Gestion_Des_Anonces.Api.Controllers;

import PFE.Gestion_Des_Anonces.Api.Models.Anonce;
import PFE.Gestion_Des_Anonces.Api.Repositories.AnonceRepository;
import PFE.Gestion_Des_Anonces.Api.Services.AnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class AnonceController {
    private final AnonceService Service;
    //private final AnonceRepository repository;
    public AnonceService getAnonceService() {
        return Service;
    }
    @Autowired
    public AnonceController(AnonceService X) {
        this.Service=X;

    }
    @CrossOrigin(origins ="*")
    @GetMapping("/Anonce")
    public List<Anonce> getAnonces(){
        return Service.getAnonces();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/Anonce",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveAnonce(@RequestBody Anonce anonce){
        Service.addAnonce(anonce);
        //repository.save(anonce);
    }
}
