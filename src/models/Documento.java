package models;

public class Documento {
	private long codigo;
	private Produto produto;
	
	public Documento(){}
	
	public Documento(long codigo, Produto produto) {
		super();
		this.codigo = codigo;
		this.produto = produto;
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
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}
	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String toString() {
		return "Documento [codigo=" + codigo + ", produto=" + produto + "]";
	}
	
	
}
