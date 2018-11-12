package br.com.caelum.contas.modelo;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Conta {
	
	private Long id;

	@NotNull
	@Size(min=5, message="{conta.formulario.descricao.tamanho}")
	private String descricao;

	private boolean paga;
	
	@NotNull(message="{conta.formulario.valor.tamanho}")
	private Double valor;

	private Calendar dataPagamento;
	
	private TipoDaConta tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoDaConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaConta tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	

}
