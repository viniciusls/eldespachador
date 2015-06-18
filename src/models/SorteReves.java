package models;


public class SorteReves {
	private long codigo;
	private String descricao;
	private Punicao acao;
	private String cor;
	
	public SorteReves(){}
	
	public SorteReves(long codigo, String descricao, Punicao acao, String cor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.acao = acao;
		this.cor = cor;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Punicao getAcao() {
		return acao;
	}

	public void setAcao(Punicao acao) {
		this.acao = acao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
