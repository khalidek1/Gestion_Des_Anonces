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

    private Timestamp DateReservationArrive;
    private Timestamp DateReservationDepart;

    public Reservation() {
    }

    public Reservation(Anonce idAnonce, Membre idMembre, Timestamp dateReservationArrive, Timestamp dateReservationDepart) {
        this.idAnonce = idAnonce;
        this.idMembre = idMembre;
        DateReservationArrive = dateReservationArrive;
        DateReservationDepart = dateReservationDepart;
    }

    public Reservation(long idReservation, Anonce idAnonce, Membre idMembre, Timestamp dateReservationArrive, Timestamp dateReservationDepart) {
        this.idReservation = idReservation;
        this.idAnonce = idAnonce;
        this.idMembre = idMembre;
        DateReservationArrive = dateReservationArrive;
        DateReservationDepart = dateReservationDepart;
    }

    public long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(long idReservation) {
        this.idReservation = idReservation;
    }

    public Anonce getIdAnonce() {
        return idAnonce;
    }

    public void setIdAnonce(Anonce idAnonce) {
        this.idAnonce = idAnonce;
    }

    public Membre getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Membre idMembre) {
        this.idMembre = idMembre;
    }

    public Timestamp getDateReservationArrive() {
        return DateReservationArrive;
    }

    public void setDateReservationArrive(Timestamp dateReservationArrive) {
        DateReservationArrive = dateReservationArrive;
    }

    public Timestamp getDateReservationDepart() {
        return DateReservationDepart;
    }

    public void setDateReservationDepart(Timestamp dateReservationDepart) {
        DateReservationDepart = dateReservationDepart;
    }
}
