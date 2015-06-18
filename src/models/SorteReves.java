package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.BD;

public class SorteReves {
	private long codigo;
	private String descricaoPort;
	private String descricaoIng;
	private String acao;
	private int tipo;
	
	public SorteReves(){}
	
	public SorteReves(long codigo, String descricaoPort, String descricaoIng, String acao) {
		super();
		this.codigo = codigo;
		this.descricaoPort = descricaoPort;
		this.descricaoIng = descricaoIng;
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
	public String getDescricaoPort() {
		return descricaoPort;
	}

	/**
	 * @param descricaoPort the descricaoPort to set
	 */
	public void setDescricaoPort(String descricaoPort) {
		this.descricaoPort = descricaoPort;
	}

	/**
	 * @return the descricaoIng
	 */
	public String getDescricaoIng() {
		return descricaoIng;
	}

	/**
	 * @param descricaoIng the descricaoIng to set
	 */
	public void setDescricaoIng(String descricaoIng) {
		this.descricaoIng = descricaoIng;
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

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "SorteReves [codigo=" + codigo + ", descricaoPort=" + descricaoPort
				+ ", descricaoIng=" + descricaoIng + ", acao=" + acao + "]";
	}
	
	public SorteReves getCartaRandom(BD bd, int tipoCarta) {
		String sql, msg;
		int idCarta = (int) (Math.random() * 24) + 1;
		sql = "Select * from sortereves where codigo_sortereves = ? and tipo_sortereves = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setInt(1, idCarta);
			bd.st.setInt(2, tipoCarta);
			
			ResultSet rs = null;
			rs = bd.st.executeQuery();
			rs.next();
			this.setDescricaoPort(rs.getString("sortereves_descPort"));
			this.setDescricaoIng(rs.getString("sortereves_descIng"));
			this.setAcao(rs.getString("sortereves_Acao"));
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			System.out.println(erro);
		}
		bd.close();
		return this;
	}
}
