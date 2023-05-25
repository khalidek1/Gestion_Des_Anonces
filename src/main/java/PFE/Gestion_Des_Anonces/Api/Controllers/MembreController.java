package PFE.Gestion_Des_Anonces.Api.Controllers;
import PFE.Gestion_Des_Anonces.Api.Models.Membre;
import PFE.Gestion_Des_Anonces.Api.Services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

@RestController()
public class MembreController {
    private MembreService Service;

    public MembreService getService() {
        return Service;
    }

    public void setService(MembreService service) {
        Service = service;
    }

    @Autowired
    public MembreController(MembreService service) {
        Service = service;
    }

    @GetMapping(path="/Membre")
    public List<Membre> getAll(){
        return Service.getMembres();
    }


    @PostMapping(path = "/Membre",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void create(@RequestBody Membre newUser) {

        Service.addMembre(newUser);
    }

    //post mapping by id ->emmail mot passe



}
