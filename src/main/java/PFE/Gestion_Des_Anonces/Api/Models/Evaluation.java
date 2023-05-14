package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Evaluation")
public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvaluation;

    private Integer nbretoiles;

    private String contenu;

    private Timestamp datePublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProprietaire")
    private Membre idProprietaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMembre")
    private Membre idMembre;

    public Evaluation() {
    }

    public Evaluation(Integer nbretoiles, String contenu, Timestamp datePublication, Membre proprietaire, Membre idMembre) {
        this.nbretoiles = nbretoiles;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.idProprietaire = proprietaire;
        this.idMembre = idMembre;
    }

    public Evaluation(long idEvaluation, Integer nbretoiles, String contenu, Timestamp datePublication, Membre proprietaire, Membre idMembre) {
        this.idEvaluation = idEvaluation;
        this.nbretoiles = nbretoiles;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.idProprietaire = proprietaire;
        this.idMembre = idMembre;
    }

    public long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Integer getNbretoiles() {
        return nbretoiles;
    }

    public void setNbretoiles(Integer nbretoiles) {
        this.nbretoiles = nbretoiles;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Timestamp datePublication) {
        this.datePublication = datePublication;
    }

    public Membre getProprietaire() {
        return idProprietaire;
    }

    public void setProprietaire(Membre proprietaire) {
        this.idProprietaire = proprietaire;
    }

    public Membre getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Membre idMembre) {
        this.idMembre = idMembre;
    }
}

