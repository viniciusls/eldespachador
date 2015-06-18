package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Produto;
import bd.BD;


public class ProdutosDAO extends Produto {
private BD bd = new BD();
	
	private String sql, men;
	
	public ArrayList<Produto> getProdutosByLimit(int quantidade) {
		sql = "Select * from Produtos";
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);

			ResultSet rs = null;
			rs = bd.st.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setCodigo(rs.getLong("cod_produto"));
				produto.setNome(rs.getString("nome_produto"));
				produto.setIncoterm(rs.getString("incoterm_produto"));
				produto.setQuantidade(rs.getInt("quantidade_produto"));
				produto.setPeso(rs.getString("peso_produto"));
				produto.setOrigem(rs.getString("origem_produto"));
				produto.setDestino(rs.getString("destino_produto"));
				produtos.add(produto);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha no carregamento");
			e.printStackTrace();
		}
		return produtos;

	}
}
