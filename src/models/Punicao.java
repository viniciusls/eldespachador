package models;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.BD;

public class Punicao {
	private long codigo;
	private String descricao;
	private String acao;
	
	public Punicao(){}
	
	public Punicao(long codigo, String descricao,
			String acao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.acao = acao;
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
	 * @return the descricaoPort
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricaoPort the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the acao
	 */
	public String getAcao() {
		return acao;
	}

	/**
	 * @param acao the acao to set
	 */
	public void setAcao(String acao) {
		this.acao = acao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Punicao [codigo=" + codigo + ", descricao=" + descricao
				+ ", acao=" + acao + "]";
	}

	public Punicao getPunicaoById(long idPunicao, BD bd){
		String sql;
		sql = "Select * from Punicoes where cod_Punicao = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setLong(1, idPunicao);
			
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			this.setCodigo(bd.rs.getLong("cod_Punicao"));
			this.setDescricao(bd.rs.getString("desc_Punicao"));
			this.setAcao(bd.rs.getString("acao_Punicao"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return this;
	}
	
	
}
