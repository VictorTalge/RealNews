package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Comentario;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(nome, texto, fk_noticia_id) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getFkId());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getId();
	}

	public void atualizar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET nome=?, texto=?, fk_noticia_id=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getFkId());
			stm.setInt(4, comentario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comentario carregar(int id) {
		Comentario comentario = new Comentario();
		comentario.setId(id);
		String sqlSelect = "SELECT nome, titulo FROM comentario WHERE comentario.fk_noticia_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, comentario.getFkId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNome(rs.getString("nome"));
					comentario.setTexto(rs.getString("texto"));
					comentario.setFkId(rs.getInt("fk_noticia_id"));
				} else {
					comentario.setId(-1);
					comentario.setNome(null);
					comentario.setTexto(null);
					comentario.setFkId(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}

}
