package models;

public class Produto {
	private long codigo;
	private String nome;
	private String incoterm;
	private int quantidade;
	private String peso;
	private String origem;
	private String destino;
	
	public Produto(){}
	
	public Produto(long codigo, String nome, String incoterm, int quantidade,
			String peso, String origem, String destino) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.incoterm = incoterm;
		this.quantidade = quantidade;
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
	}

	/**
	 * @return the codigo
	 */
	public long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
	 * @return the incoterm
	 */
	public String getIncoterm() {
		return incoterm;
	}

	/**
	 * @param incoterm the incoterm to set
	 */
	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}

	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String toString() {
		return "Produtos [codigo=" + codigo + ", nome=" + nome + ", incoterm="
				+ incoterm + ", quantidade=" + quantidade + ", peso=" + peso
				+ ", origem=" + origem + ", destino=" + destino + "]";
	}
	
	
	
}
