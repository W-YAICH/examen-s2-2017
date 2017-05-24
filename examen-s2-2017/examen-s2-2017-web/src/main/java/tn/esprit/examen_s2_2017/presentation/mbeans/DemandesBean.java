package tn.esprit.examen_s2_2017.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_s2_2017.persistence.Demande;
import tn.esprit.examen_s2_2017.services.UserService;

@ManagedBean
public class DemandesBean {
		
	private Integer selectedUserId;
	
	private List<Demande> demandes = new ArrayList<>();
	
	@EJB
	UserService userService;

	public void afficherDemandes(){
		demandes = userService.getDemandesByUserId(selectedUserId);
	}
	
	public Integer getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(Integer selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
}
