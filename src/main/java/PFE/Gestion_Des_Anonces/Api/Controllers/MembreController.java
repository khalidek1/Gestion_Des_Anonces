package PFE.Gestion_Des_Anonces.Api.Controllers;
import PFE.Gestion_Des_Anonces.Api.Models.Membre;
import PFE.Gestion_Des_Anonces.Api.Services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

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

    @PostMapping(path = "/Membre",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Membre> create(@RequestBody Membre newUser) {

        Membre user = Service.addMembre(newUser);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }



}
