package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bd.BD;

public class Resposta {
	private long codigo;
	private String descA_Resposta;
	private String descB_Resposta;
	private String descC_Resposta;
	private String resposta_correta;
	
	public Resposta(){}
	
	public Resposta(long codigo, String descA_Resposta, String descB_Resposta,
			String descC_Resposta, String resposta_correta, Pergunta pergunta) {
		super();
		this.codigo = codigo;
		this.descA_Resposta = descA_Resposta;
		this.descB_Resposta = descB_Resposta;
		this.descC_Resposta = descC_Resposta;
		this.resposta_correta = resposta_correta;
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
	 * @return the descA_Resposta
	 */
	public String getDescA_Resposta() {
		return descA_Resposta;
	}

	/**
	 * @param descA_Resposta the descA_Resposta to set
	 */
	public void setDescA_Resposta(String descA_Resposta) {
		this.descA_Resposta = descA_Resposta;
	}

	/**
	 * @return the descB_Resposta
	 */
	public String getDescB_Resposta() {
		return descB_Resposta;
	}

	/**
	 * @param descB_Resposta the descB_Resposta to set
	 */
	public void setDescB_Resposta(String descB_Resposta) {
		this.descB_Resposta = descB_Resposta;
	}

	/**
	 * @return the descC_Resposta
	 */
	public String getDescC_Resposta() {
		return descC_Resposta;
	}

	/**
	 * @param descC_Resposta the descC_Resposta to set
	 */
	public void setDescC_Resposta(String descC_Resposta) {
		this.descC_Resposta = descC_Resposta;
	}

	/**
	 * @return the resposta
	 */
	public String getRespostaCorreta() {
		return resposta_correta;
	}

	/**
	 * @param resposta the resposta to set
	 */
	public void setRespostaCorreta(String resposta_correta) {
		this.resposta_correta = resposta_correta;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resposta [codigo=" + codigo + ", descA_Resposta="
				+ descA_Resposta + ", descB_Resposta=" + descB_Resposta
				+ ", descC_Resposta=" + descC_Resposta + ", resposta_correta="
				+ resposta_correta + "]";
	}

	public Resposta getRespostaById(long idResposta, BD bd){
		String sql;
		sql = "Select * from Respostas where cod_Resposta = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setLong(1, idResposta);
			
			ResultSet rs = null;
			rs = bd.st.executeQuery();
			rs.next();
			
			this.setCodigo(rs.getLong("cod_Resposta"));
			this.setDescA_Resposta(rs.getString("descA_Resposta"));
			this.setDescB_Resposta(rs.getString("descB_Resposta"));
			this.setDescC_Resposta(rs.getString("descC_Resposta"));
			this.setRespostaCorreta(rs.getString("resposta_Correta"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return this;
	}
	
	public Resposta getRespostasByPergunta(long idPergunta, BD bd){
		String sql;
		sql = "Select * from Respostas where pergunta_Resposta = ?";
		Resposta resposta = new Resposta();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setLong(1, idPergunta);
			
			ResultSet rs = null;
			rs = bd.st.executeQuery();
			while(rs.next()){
				resposta.setCodigo(rs.getLong("cod_Resposta"));
				this.setDescA_Resposta(rs.getString("descA_Resposta"));
				this.setDescB_Resposta(rs.getString("descB_Resposta"));
				this.setDescC_Resposta(rs.getString("descC_Resposta"));
				resposta.setRespostaCorreta(rs.getString("resposta_Correta"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return resposta;
	}
	
}
