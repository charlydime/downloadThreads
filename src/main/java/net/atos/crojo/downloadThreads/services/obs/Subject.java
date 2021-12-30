package net.atos.crojo.downloadThreads.services.obs;

import java.util.ArrayList;
import java.util.List;



public class Subject {
	
	private List<Observador> observadores = new ArrayList<>();
	private String estado;
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
		notifyALL();
	}
	
	private void notifyALL() {
		observadores.forEach(x -> x.actualizar());
		
	}

	public void agregar (Observador obs) {
		observadores.add(obs);
	} 

}
