package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import bd.BD;
import models.Pergunta;
import models.Produto;
import models.Punicao;
import models.Resposta;
import models.SorteReves;

public class SorteRevesDAO extends SorteReves{
private BD bd = new BD();
	
	private String sql, men;
	
	public SorteReves getSorteRevesById(long idSorteReves) {
		sql = "Select * from SorteReves where cod_SorteReves = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setLong(1, idSorteReves);

			ResultSet rs = null;
			rs = bd.st.executeQuery();
			rs.next();
			this.setCodigo(rs.getLong("cod_SorteReves"));
			this.setDescricao(rs.getString("carta_SorteReves"));
			Punicao punicao = new Punicao();
			this.setPunicao(punicao.getPunicaoById(
					rs.getInt("acao_SorteReves"), bd));
			this.setCor(rs.getString("cor_SorteReves"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return this;

	}

	public SorteReves selecionarSorteReves(String cor) {
		sql = "Select * from SorteReves where cor_SorteReves = ?";
		ArrayList<SorteReves> sorteRevesArray = new ArrayList<SorteReves>();
		SorteReves sorteReves = new SorteReves();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			bd.st.setString(1, cor);
			ResultSet rs = null;
			rs = bd.st.executeQuery();
			while(rs.next()){
				SorteReves sorteRevesObj = new SorteReves();
				sorteRevesObj.setCodigo(rs.getLong("cod_SorteReves"));
				sorteRevesObj.setDescricao(rs.getString("carta_SorteReves"));
				Punicao punicao = new Punicao();
				sorteRevesObj.setPunicao(punicao.getPunicaoById(
						rs.getInt("acao_SorteReves"), bd));
				sorteRevesObj.setCor(rs.getString("cor_SorteReves"));
				sorteRevesArray.add(sorteRevesObj);
			}
			Collections.shuffle(sorteRevesArray);
			
			sorteReves = sorteRevesArray.get(0);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return sorteReves;
	}
}
