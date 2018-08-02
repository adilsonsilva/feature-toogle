package br.com.toggle.api.enums;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum Funcionalidade implements Feature {

	@Label("Habilit mostrar sobre nome pessoa")
	HABILITA_SOBRE_NOME;

	public boolean isActive() {
		return FeatureContext.getFeatureManager().isActive(this);
	}

}
