package PFE.Gestion_Des_Anonces.Api.DTO_CLASSES;

import java.util.List;

public record ANONCE_DTO_SEARCH(
         long idAnonce,
         int surface , int nbreSalleBain , int nbreEtages ,int nbreChambres,
         int nbreEtoiles,
         float prix,float latitude ,float longitude ,
         char type , char etat,
         String email,
         String telephone,
         String nomAnonce,
         String description,
         List<String>categories,
         List<COMMENTAIRE_DTO_SEARCH> commentaires,
         String idVille ,
         String idRegion
){
}
