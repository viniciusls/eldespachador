package models;

public class Jogador {
	
	private String nome;
	private int posicao;
	private int semJogar;
	private boolean isParametrizacao;
	private Produto produto;
	private int documentos;
	
	public Jogador(){}
	
	public Jogador(String nome, int posicao, int semJogar,
			boolean isParametrizacao, Produto produto, int documentos) {
		super();
		this.nome = nome;
		this.posicao = posicao;
		this.semJogar = semJogar;
		this.isParametrizacao = isParametrizacao;
		this.produto = produto;
		this.documentos = documentos;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the posicao
	 */
	public int getPosicao() {
		return posicao;
	}

	/**
	 * @param posicao the posicao to set
	 */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getSemJogar() {
		return semJogar;
	}

	public void setSemJogar(int semJogar) {
		this.semJogar = semJogar;
	}

	public boolean isParametrizacao() {
		return isParametrizacao;
	}

	public void setParametrizacao(boolean isParametrizacao) {
		this.isParametrizacao = isParametrizacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the documentos
	 */
	public int getDocumentos() {
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(int documentos) {
		this.documentos = documentos;
	}
	
}
