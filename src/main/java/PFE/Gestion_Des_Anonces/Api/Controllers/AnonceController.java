package PFE.Gestion_Des_Anonces.Api.Controllers;

import PFE.Gestion_Des_Anonces.Api.Models.Anonce;
import PFE.Gestion_Des_Anonces.Api.Services.AnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class AnonceController {
    private final AnonceService anonceService;
    public AnonceService getAnonceService() {
        return anonceService;
    }
    @Autowired
    public AnonceController(AnonceService X) {
        this.anonceService=X;
    }

    @GetMapping("/Anonce")
    public List<Anonce> getAnonce(){
        System.out.println("Get Request detected!");
        return anonceService.getAnonces();
    }
}
