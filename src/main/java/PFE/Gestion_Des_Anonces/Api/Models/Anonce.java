package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

@Entity
@Table(name = "Anonce")
public class Anonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idAnonce;
    private int surface , nbreSalleBain , nbreEtages , nbreChambres;
    private float prix, coordonneX , coordonneY ;
    private char type , etat;
    private Timestamp dateCreationAnonce;
    private String email,telephone,nomAnonce;

    @ManyToOne
    @JoinColumn(name = "idVille")
    private Ville idVille;

    @ManyToOne
    @JoinColumn(name = "idProprietaire")
    private Membre idProprietaire;

    public String getNomAnonce() {
        return nomAnonce;
    }

    public void setNomAnonce(String nomAnonce) {
        this.nomAnonce = nomAnonce;
    }

    public ArrayList<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(ArrayList<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @ManyToMany
    @JoinTable(
            name = "Categories_Anonces",
            joinColumns = @JoinColumn(name = "idAnonce"),
            inverseJoinColumns = @JoinColumn(name = "idCategorie")
    )
    private ArrayList<Categorie> categories;

    @OneToMany(mappedBy="idAnonce")
    private ArrayList<Reservation> Reservations;

    @OneToMany(mappedBy="idAnonce")
    private ArrayList<Commentaire> commentaires;

    public Anonce() {
    }

    public Anonce(int surface, int nbreSalleBain, int nbreEtages, int nbreChambres, float prix, float coordonneX, float coordonneY, char type, char etat, Timestamp dateCreationAnonce, String email, String telephone, String nomAnonce, Ville idVille, Membre idProprietaire, ArrayList<Categorie> categories, ArrayList<Reservation> reservations) {
        this.surface = surface;
        this.nbreSalleBain = nbreSalleBain;
        this.nbreEtages = nbreEtages;
        this.nbreChambres = nbreChambres;
        this.prix = prix;
        this.coordonneX = coordonneX;
        this.coordonneY = coordonneY;
        this.type = type;
        this.etat = etat;
        this.dateCreationAnonce = dateCreationAnonce;
        this.email = email;
        this.telephone = telephone;
        this.nomAnonce = nomAnonce;
        this.idVille = idVille;
        this.idProprietaire = idProprietaire;
        this.categories = categories;
        Reservations = reservations;
    }

    public Anonce(long idAnonce, int surface, int nbreSalleBain, int nbreEtages, int nbreChambres, float prix, float coordonneX, float coordonneY, char type, char etat, Timestamp dateCreationAnonce, String email, String telephone, String nomAnonce, Ville idVille, Membre idProprietaire, ArrayList<Categorie> categories, ArrayList<Reservation> reservations) {
        this.idAnonce = idAnonce;
        this.surface = surface;
        this.nbreSalleBain = nbreSalleBain;
        this.nbreEtages = nbreEtages;
        this.nbreChambres = nbreChambres;
        this.prix = prix;
        this.coordonneX = coordonneX;
        this.coordonneY = coordonneY;
        this.type = type;
        this.etat = etat;
        this.dateCreationAnonce = dateCreationAnonce;
        this.email = email;
        this.telephone = telephone;
        this.nomAnonce = nomAnonce;
        this.idVille = idVille;
        this.idProprietaire = idProprietaire;
        this.categories = categories;
        Reservations = reservations;
    }

    public long getIdAnonce() {
        return idAnonce;
    }

    public void setIdAnonce(long idAnonce) {
        this.idAnonce = idAnonce;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getNbreSalleBain() {
        return nbreSalleBain;
    }

    public void setNbreSalleBain(int nbreSalleBain) {
        this.nbreSalleBain = nbreSalleBain;
    }

    public int getNbreEtages() {
        return nbreEtages;
    }

    public void setNbreEtages(int nbreEtages) {
        this.nbreEtages = nbreEtages;
    }

    public int getNbreChambres() {
        return nbreChambres;
    }

    public void setNbreChambres(int nbreChambres) {
        this.nbreChambres = nbreChambres;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getCoordonneX() {
        return coordonneX;
    }

    public void setCoordonneX(float coordonneX) {
        this.coordonneX = coordonneX;
    }

    public float getCoordonneY() {
        return coordonneY;
    }

    public void setCoordonneY(float coordonneY) {
        this.coordonneY = coordonneY;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    public Timestamp getDateCreationAnonce() {
        return dateCreationAnonce;
    }

    public void setDateCreationAnonce(Timestamp dateCreationAnonce) {
        this.dateCreationAnonce = dateCreationAnonce;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville idVille) {
        this.idVille = idVille;
    }

    public Membre getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Membre idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public ArrayList<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categorie> categories) {
        this.categories = categories;
    }

    public ArrayList<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        Reservations = reservations;
    }
}
