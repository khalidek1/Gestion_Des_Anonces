package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Ville")
public class Ville {
    @Id
    private String idVille;

    @ManyToOne()
    @JoinColumn(name = "idRegion")
    private Region idRegion;

    @OneToMany(mappedBy = "idVille")
    private List<Anonce> Anonces;

    public Ville(String idVille, Region idRegion) {
        this.idVille = idVille;
        this.idRegion = idRegion;
    }

    public Ville() {
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public Region getIdRegin() {
        return idRegion;
    }

    public void setIdRegin(Region idRegion) {
        this.idRegion = idRegion;
    }
}

