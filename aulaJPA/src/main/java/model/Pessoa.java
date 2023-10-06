package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {
		private static final long serialVersionUID = 1L;
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY) private Integer id;
		private String nome;
		private String email;
		private String login;
		private String senha;

		public Pessoa() {
			super();
		}

		public Pessoa(Integer id, String nome, String email, String login, String senha) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.login = login;
			this.setSenha(senha);
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + "]";
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

	}

