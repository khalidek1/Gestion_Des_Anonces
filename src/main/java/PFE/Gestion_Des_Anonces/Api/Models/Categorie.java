package PFE.Gestion_Des_Anonces.Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {
    @Id
    private String idCategorie;

    @JsonIgnore
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

