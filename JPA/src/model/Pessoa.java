package model;

import java.io.Serializable;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String email;
	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	
}
