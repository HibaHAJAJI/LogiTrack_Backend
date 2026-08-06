package com.example.demo.dashboard;



import com.example.demo.entity.Commande;
import com.example.demo.enums.Statut;
import com.example.demo.mapper.CommandeMapper;
import com.example.demo.repository.ClientRepos;
import com.example.demo.repository.CommandeRepos;
import com.example.demo.repository.LigneCommandeRepos;
import com.example.demo.repository.ProduitRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ClientRepos clientRepos;
    private final CommandeRepos commandeRepos;
    private  final ProduitRepos produitRepos;
    private final LigneCommandeRepos ligneCommandeRepos;
    private final CommandeMapper commandeMapper;

    public DashboardDTO getDashboard(){

        DashboardDTO dto =new DashboardDTO();

        dto.setTotalClients(clientRepos.count());
        dto.setTotalProduits(produitRepos.count());
        dto.setTotalCommandes(commandeRepos.count());


        dto.setCommandesEnAttente(commandeRepos.countByStatut(Statut.EN_ATTENTE));
        dto.setCommandesExpediees(commandeRepos.countByStatut(Statut.EXPEDIEE));
        dto.setCommandesLivrees(commandeRepos.countByStatut(Statut.LIVREE));


        dto.setProduitsStockFaible(produitRepos.findLowStock(10,
                PageRequest.of(0, 100)).getTotalElements());


        Page<String>page = ligneCommandeRepos.findMostOrderedProduct(PageRequest.of(0,1));
        if(!page.isEmpty()){
         dto.setProduitPlusCommande(page.getContent().get(0));
        }

        Page<Commande> commandes = commandeRepos.findRecentCommandes(PageRequest.of(0, 5));
        dto.setCommandesRecents(commandeMapper.toDtoList(commandes.getContent()));



        return dto;

    }
}
