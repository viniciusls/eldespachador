package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.BD;

public class Pergunta {
	private long codigo;
	private String descricao;
	private Punicao punicao;
	private Resposta resposta;

	public Pergunta() {
	}

	public Pergunta(long codigo, String descricao, String descricaoIng,
			Punicao punicao, Resposta resposta) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.punicao = punicao;
		this.resposta = resposta;
	}

	/**
	 * @return the codigo
	 */
	public long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descPort
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the punicao
	 */
	public Punicao getPunicao() {
		return punicao;
	}

	/**
	 * @param punicao
	 *            the punicao to set
	 */
	public void setPunicao(Punicao punicao) {
		this.punicao = punicao;
	}

	/**
	 * @return the resposta
	 */
	public Resposta getResposta() {
		return resposta;
	}

	/**
	 * @param resposta
	 *            the resposta to set
	 */
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public String toString() {
		return "Pergunta [codigo=" + codigo + ", descricao="
				+ descricao + "]";
	}

	public boolean validarResposta(Pergunta pergunta, String resposta){
		try{
			if(resposta.equalsIgnoreCase(pergunta.getResposta().getRespostaCorreta())){
				return true;
			}else{
				return false;
			}
		}catch(NullPointerException e){
			return false;
		}
	}
	
}
