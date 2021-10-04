package org.apache.struts.example.crud.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String descricao;

	private boolean finalizado;

	private LocalDate dtFinalizado;

	private LocalDate dtCriacao;

	private LocalDate dtUltAt;

	private boolean excluido;
	
	public Tarefa() {}
	
	public Tarefa(String descricao) {
		this.descricao = descricao;
	}

	public Tarefa(Integer id, String descricao, boolean finalizado, LocalDate dtFinalizado, LocalDate dtCriacao,
			LocalDate dtUltAt, boolean excluido) {
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dtFinalizado = dtFinalizado;
		this.dtCriacao = dtCriacao;
		this.dtUltAt = dtUltAt;
		this.excluido = excluido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public LocalDate getDtFinalizado() {
		return dtFinalizado;
	}

	public void setDtFinalizado(LocalDate dtFinalizado) {
		this.dtFinalizado = dtFinalizado;
	}

	public LocalDate getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDate dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public LocalDate getDtUltAt() {
		return dtUltAt;
	}

	public void setDtUltAt(LocalDate dtUltAt) {
		this.dtUltAt = dtUltAt;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", descricao=" + descricao + ", finalizado=" + finalizado + ", dtFinalizado="
				+ dtFinalizado + ", dtCriacao=" + dtCriacao + ", dtUltAt=" + dtUltAt + ", excluido=" + excluido + "]";
	}
}
