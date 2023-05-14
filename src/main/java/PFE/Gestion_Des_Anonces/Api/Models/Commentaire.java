package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "Commentaire")
public class Commentaire  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCommentaire;

    private int nbretoiles;

    private String contenu;

    private Timestamp DatePublication;

    @ManyToOne
    @JoinColumn(name = "idMembre")
    private Membre idMembre;

    @ManyToOne
    @JoinColumn(name = "idAnonce")
    private Anonce idAnonce;

    public Commentaire(int nbretoiles, String contenu, Timestamp datePublication, Membre idMembre, Anonce idAnonce) {
        this.nbretoiles = nbretoiles;
        this.contenu = contenu;
        DatePublication = datePublication;
        this.idMembre = idMembre;
        this.idAnonce = idAnonce;
    }

    public Commentaire() {
    }

    public Commentaire(long idCommentaire, int nbretoiles, String contenu, Timestamp datePublication, Membre idMembre, Anonce idAnonce) {
        this.idCommentaire = idCommentaire;
        this.nbretoiles = nbretoiles;
        this.contenu = contenu;
        DatePublication = datePublication;
        this.idMembre = idMembre;
        this.idAnonce = idAnonce;
    }

    public long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getNbretoiles() {
        return nbretoiles;
    }

    public void setNbretoiles(int nbretoiles) {
        this.nbretoiles = nbretoiles;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(Timestamp datePublication) {
        DatePublication = datePublication;
    }

    public Membre getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Membre idMembre) {
        this.idMembre = idMembre;
    }

    public Anonce getIdAnonce() {
        return idAnonce;
    }

    public void setIdAnonce(Anonce idAnonce) {
        this.idAnonce = idAnonce;
    }
}

