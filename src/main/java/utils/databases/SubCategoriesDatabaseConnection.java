package utils.databases;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import utils.ProductSubCategory;

public class SubCategoriesDatabaseConnection extends DatabaseConnection {


    @Override
    protected void createTable(Connection connection) {
        String subCategorySQL = "CREATE TABLE IF NOT EXISTS SubCategorias (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CategoriaID INTEGER NOT NULL," +
                "Nombre TEXT NOT NULL," +
                "FOREIGN KEY (CategoriaID) REFERENCES Categorias(ID)" +
                ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.setQueryTimeout(QUERY_TIMEOUT);
            stmt.execute(subCategorySQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertSubCategory(String nombre) throws SQLException {
        String sql = "INSERT INTO SubCategorias(Nombre) VALUES(?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "SubCategoria creada con éxito!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la SubCategoria.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getSubCategories(String searchText) throws SQLException {
        ArrayList<String> subCategorias = new ArrayList<>();
        String sql = "SELECT Nombre FROM SubCategorias";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                subCategorias.add(resultSet.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subCategorias;
    }


}