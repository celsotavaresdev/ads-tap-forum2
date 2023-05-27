package br.unisanta.ads.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BookDAL {
	private static final String DATABASE = "BDLivros.mdb";
	private static final String DATABASE_TABLE = "TabLivro";

	private static Connection connection = null;

	private BookDAL() {
	}

	public static Connection getConnection() throws SQLException
	{
		if (connection == null) {
			try {
		        connection = DriverManager.getConnection("jdbc:ucanaccess://" + DATABASE);
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados","Erro", JOptionPane.ERROR_MESSAGE);
		        throw e;
		    }
		}

	    return connection;
	}

	public static void create(Book book) throws SQLException {
		String sqlQuery = "INSERT INTO " + DATABASE_TABLE + " (codigo, titulo, autor, editora, ano) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = BookDAL.getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, book.getCodigo());
            statement.setString(2, book.getTitulo());
            statement.setString(3, book.getAutor());
            statement.setString(4, book.getEditora());
            statement.setString(5, book.getAno());
            statement.executeUpdate();
        } catch (SQLException e) {
        	throw e;
        }
	}

	public static Book get(String codigo) throws SQLException {
        Book book = new Book();
        boolean check = false;

        String sqlQuery = "SELECT * FROM " + DATABASE_TABLE + " WHERE codigo = ? LIMIT 0,1";

        try (PreparedStatement statement = BookDAL.getConnection().prepareStatement(sqlQuery)) {
    		statement.setString(1, codigo);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                check = true;
                book.setCodigo(result.getString("codigo"));
                book.setTitulo(result.getString("titulo"));
                book.setAutor(result.getString("autor"));
                book.setEditora(result.getString("editora"));
                book.setAno(result.getString("ano"));
            }
        } catch (SQLException e) {
        	throw e;
        }

        return check ? book : null;
    }

	public static void delete(String codigo) throws SQLException {
		String sqlQuery = "DELETE FROM " + DATABASE_TABLE + " WHERE codigo = ?";

        try (PreparedStatement statement = BookDAL.getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, codigo);
            statement.executeUpdate();
        } catch (SQLException e) {
        	throw e;
        }
	}
	
	public static void update(Book book) throws SQLException
    {
		String sqlQuery = "UPDATE " + DATABASE_TABLE + " SET titulo = ?, autor = ?, editora = ?, ano = ? WHERE codigo = ?";
		
		try (PreparedStatement statement = BookDAL.getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, book.getTitulo());
            statement.setString(2, book.getAutor());
            statement.setString(3, book.getEditora());
            statement.setString(4, book.getAno());
            statement.setString(5, book.getCodigo());
            statement.executeUpdate();
        } catch (SQLException e) {
        	throw e;
        }
    }

}