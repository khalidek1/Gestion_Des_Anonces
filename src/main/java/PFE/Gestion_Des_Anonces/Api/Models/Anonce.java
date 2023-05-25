package PFE.Gestion_Des_Anonces.Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Anonce")
public class Anonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnonce;
    private int surface , nbreSalleBain , nbreEtages , nbreChambres;
    private float prix, latitude , longitude ;
    private char type , etat;
    private Timestamp dateCreationAnonce;
    private String email;
    private String telephone;
    private String nomAnonce;
    private String description;

    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "idVille")
    private Ville idVille;

    @ManyToOne
    @JoinColumn(name = "idProprietaire")
    private Membre idProprietaire;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Categories_Anonces",
            joinColumns = @JoinColumn(name = "idAnonce"),
            inverseJoinColumns = @JoinColumn(name = "idCategorie")
    )
    private List<Categorie> categories;

    @OneToMany(mappedBy="idAnonce")
    private List<Reservation> Reservations;

    @OneToMany(mappedBy="idAnonce")
    private List<Commentaire> commentaires;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
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

    public String getNomAnonce() {
        return nomAnonce;
    }

    public void setNomAnonce(String nomAnonce) {
        this.nomAnonce = nomAnonce;
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

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Anonce(int surface, int nbreSalleBain, int nbreEtages, int nbreChambres, float prix, float latitude, float longitude, char type, char etat, Timestamp dateCreationAnonce, String email, String telephone, String nomAnonce, String description, String imageUrl, Ville idVille, Membre idProprietaire, List<Categorie> categories, List<Reservation> reservations, List<Commentaire> commentaires) {
        this.surface = surface;
        this.nbreSalleBain = nbreSalleBain;
        this.nbreEtages = nbreEtages;
        this.nbreChambres = nbreChambres;
        this.prix = prix;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.etat = etat;
        this.dateCreationAnonce = dateCreationAnonce;
        this.email = email;
        this.telephone = telephone;
        this.nomAnonce = nomAnonce;
        this.description = description;
        this.imageUrl = imageUrl;
        this.idVille = idVille;
        this.idProprietaire = idProprietaire;
        this.categories = categories;
        Reservations = reservations;
        this.commentaires = commentaires;
    }

    public Anonce() {
    }

    public Anonce(long idAnonce, int surface, int nbreSalleBain, int nbreEtages, int nbreChambres, float prix, float latitude, float longitude, char type, char etat, Timestamp dateCreationAnonce, String email, String telephone, String nomAnonce, String description, String imageUrl, Ville idVille, Membre idProprietaire, List<Categorie> categories, List<Reservation> reservations, List<Commentaire> commentaires) {
        this.idAnonce = idAnonce;
        this.surface = surface;
        this.nbreSalleBain = nbreSalleBain;
        this.nbreEtages = nbreEtages;
        this.nbreChambres = nbreChambres;
        this.prix = prix;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.etat = etat;
        this.dateCreationAnonce = dateCreationAnonce;
        this.email = email;
        this.telephone = telephone;
        this.nomAnonce = nomAnonce;
        this.description = description;
        this.imageUrl = imageUrl;
        this.idVille = idVille;
        this.idProprietaire = idProprietaire;
        this.categories = categories;
        Reservations = reservations;
        this.commentaires = commentaires;
    }
}
