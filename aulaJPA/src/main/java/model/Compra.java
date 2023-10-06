package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;
	private Date data;
	private String FormaDePagamento;
	
	@ManyToOne
	@JoinColumn(name = "Pessoa_idPessoa")
	private Pessoa Pessoa;

	public Compra() {
		super();
	}
	
	public Compra(Integer idCompra, Date data, String formaDePagamento, Pessoa pessoa) {
		super();
		this.idCompra = idCompra;
		this.data = data;
		FormaDePagamento = formaDePagamento;
		Pessoa = pessoa;
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFormaDePagamento() {
		return FormaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		FormaDePagamento = formaDePagamento;
	}

	public Pessoa getPessoa_idPessoa() {
		return Pessoa;
	}

	public void setPessoa_idPessoa(Pessoa pessoa) {
		Pessoa = pessoa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}