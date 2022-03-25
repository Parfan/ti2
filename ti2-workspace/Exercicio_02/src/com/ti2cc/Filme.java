package com.ti2cc;

public class Filme {
	private int codigo;
	private String titulo;
	private String categoria;
	private int minutos;
	private int ano;
	private String ator_principal;
	private int avaliacao;
	
	public Filme() {
		this.codigo = -1;
		this.titulo = "";
		this.categoria ="";
		this.minutos = 0;
		this.ano = 0;
		this.ator_principal = "";
		this.avaliacao = 0;
	}
	
	public Filme(int codigo, String titulo, String categoria, int minutos, int ano, String ator_principal,
			int avaliacao) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.minutos = minutos;
		this.ano = ano;
		this.ator_principal = ator_principal;
		this.avaliacao = avaliacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAtor_principal() {
		return ator_principal;
	}

	public void setAtor_principal(String ator_principal) {
		this.ator_principal = ator_principal;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public String toString() {
		return "Filme [codigo=" + codigo + ", titulo=" + titulo + ", categoria=" + categoria + ", minutos=" + minutos
				+ ", ano=" + ano + ", ator_principal=" + ator_principal + ", avaliacao=" + avaliacao + "]";
	}
}
