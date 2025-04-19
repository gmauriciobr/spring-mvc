package br.com.gmauricio.service.impl;

import br.com.gmauricio.service.PersistenceService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersistenceServiceImpl implements PersistenceService {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


}
