package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {
    @Id
    private String idCategorie;

    @ManyToMany(mappedBy="categories")
    private ArrayList<Anonce> Anonces;

    public Categorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Categorie() {
    }
}

