package PFE.Gestion_Des_Anonces.Api.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "Membre")
public class Membre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMembre;
    private String email,nom,password,prenom;

    private char sexe;
    private Timestamp dateNaissance,dateCreationCompte;
    @OneToMany(mappedBy = "idProprietaire")
    private List<Anonce> anonces;
    @OneToMany(mappedBy = "idMembre")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "idMembre")
    private List<Commentaire> commentaires;
    @OneToMany(mappedBy = "idMembre")
    private List<Evaluation> evaluations;
    @OneToMany(mappedBy = "idProprietaire")
    private List<Evaluation> evaluationsCree;
    public Membre() {
    }
    public Membre(String email, String nom, String password, String prenom, char sexe, Timestamp dateNaissance, Timestamp dateCreationCompte, List<Anonce> anonces, List<Reservation> reservations, List<Commentaire> commentaires, List<Evaluation> evaluations) {
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.dateCreationCompte = dateCreationCompte;
        this.anonces = anonces;
        this.reservations = reservations;
        this.commentaires = commentaires;
        this.evaluations = evaluations;
    }
    public Membre(long idMembre, String email, String nom, String password, String prenom, char sexe, Timestamp dateNaissance, Timestamp dateCreationCompte, List<Anonce> anonces, List<Reservation> reservations, List<Commentaire> commentaires, List<Evaluation> evaluations) {
        this.idMembre = idMembre;
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.dateCreationCompte = dateCreationCompte;
        this.anonces = anonces;
        this.reservations = reservations;
        this.commentaires = commentaires;
        this.evaluations = evaluations;
    }
    public long getIdMembre() {
        return idMembre;
    }
    public void setIdMembre(long idMembre) {
        this.idMembre = idMembre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public char getSexe() {
        return sexe;
    }
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }
    public Timestamp getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Timestamp dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Timestamp getDateCreationCompte() {
        return dateCreationCompte;
    }
    public void setDateCreationCompte(Timestamp dateCreationCompte) {
        this.dateCreationCompte = dateCreationCompte;
    }
    public List<Anonce> getAnonces() {
        return anonces;
    }
    public void setAnonces(List<Anonce> anonces) {
        this.anonces = anonces;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    public List<Commentaire> getCommentaires() {
        return commentaires;
    }
    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    public List<Evaluation> getEvaluations() {
        return evaluations;
    }
    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}

