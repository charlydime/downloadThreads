package net.atos.crojo.downloadThreads.services.obs;

public class DescargaObs extends Observador {
	
	public DescargaObs(Subject sujeto) {
		this.sujeto = sujeto;
		this.sujeto.agregar(this);
	
	}

	@Override
	public void actualizar() {
		
		System.out.println(sujeto.getEstado());

	}

}
