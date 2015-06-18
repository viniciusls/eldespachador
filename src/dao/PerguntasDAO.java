package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import bd.BD;
import models.Pergunta;
import models.Punicao;
import models.Resposta;

public class PerguntasDAO extends Pergunta {
	
	private BD bd = new BD();
	
	private String sql, men;
	
	public Pergunta getPerguntaById(long idPergunta) {
		sql = "Select * from Perguntas where cod_Pergunta = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setLong(1, idPergunta);

			ResultSet rs = null;
			rs = bd.st.executeQuery();
			rs.next();
			this.setCodigo(rs.getLong("cod_Pergunta"));
			this.setDescricao(rs.getString("descricao_Pergunta"));
			Punicao punicao = new Punicao();
			this.setPunicao(punicao.getPunicaoById(
					rs.getInt("punicao_Pergunta"), bd));
			Resposta resposta = new Resposta();
			this.setResposta(resposta.getRespostaById(
					rs.getInt("resposta_Pergunta"), bd));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return this;

	}

	public Pergunta selecionarPergunta() {
		int idPergunta = (int) (Math.random() * 33) + 1;
		sql = "Select * from Perguntas where cod_Pergunta = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setInt(1, idPergunta);
			ResultSet rs = null;
			rs = bd.st.executeQuery();
			rs.next();
			this.setCodigo(rs.getLong("cod_Pergunta"));
			this.setDescricao(rs.getString("descricao_Pergunta"));
			Punicao punicao = new Punicao();
			this.setPunicao(punicao.getPunicaoById(
					rs.getInt("punicao_Pergunta"), bd));
			Resposta resposta = new Resposta();
			this.setResposta(resposta.getRespostaById(rs.getInt("resposta_Pergunta"), bd));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return this;
	}
	
}
