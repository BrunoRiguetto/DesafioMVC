package com.gft.DesafioMVC.domain;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), USUARIOLOGADO(2, "USUARIOLOGADO");
	
	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
