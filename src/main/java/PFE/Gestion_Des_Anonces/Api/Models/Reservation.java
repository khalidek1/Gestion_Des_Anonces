package PFE.Gestion_Des_Anonces.Api.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name="Reservation")
public class Reservation implements Serializable {
    @Id
    private long idReservation;
    @ManyToOne
    @JoinColumn(name = "idAnonce")
    private Anonce idAnonce;

    @ManyToOne
    @JoinColumn(name = "idMembre")
    private Membre idMembre;
    private Timestamp DateReservation;

    public Reservation() {
    }

    public Reservation(Anonce anonce, Membre membre, Timestamp dateReservation) {
        this.idAnonce = anonce;
        this.idMembre = membre;
        DateReservation = dateReservation;
    }

    public Reservation(long idReservation, Anonce anonce, Membre membre, Timestamp dateReservation) {
        this.idReservation = idReservation;
        this.idAnonce = anonce;
        this.idMembre = membre;
        DateReservation = dateReservation;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }

    public Anonce getAnonce() {
        return idAnonce;
    }

    public void setAnonce(Anonce anonce) {
        this.idAnonce = anonce;
    }

    public Membre getMembre() {
        return idMembre;
    }

    public void setMembre(Membre membre) {
        this.idMembre = membre;
    }

    public Timestamp getDateReservation() {
        return DateReservation;
    }

    public void setDateReservation(Timestamp dateReservation) {
        DateReservation = dateReservation;
    }
}
