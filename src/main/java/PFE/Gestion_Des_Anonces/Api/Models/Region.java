package PFE.Gestion_Des_Anonces.Api.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Region implements Serializable {

        @Column(name="idRegion")
        @Id
        private String idRegion;

        @OneToMany(mappedBy="idRegion")
        private List<Ville> villes;

        public String getIdRegion() {
                return idRegion;
        }

        public void setIdRegion(String idRegion) {
                this.idRegion = idRegion;
        }

        public Region(String idRegion) {
                this.idRegion = idRegion;
        }

        public Region() {
        }
}
