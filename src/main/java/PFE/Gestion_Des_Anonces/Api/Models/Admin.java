package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Admin")
public class Admin implements Serializable {
    @Id
    private String emailAdmin;
    private String passAdmin;

    public Admin(String emailAdmin, String passAdmin) {
        this.emailAdmin = emailAdmin;
        this.passAdmin = passAdmin;
    }

    public Admin() {
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }
}
