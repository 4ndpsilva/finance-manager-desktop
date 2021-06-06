package aps.financemanagerdesktop.dao;

import aps.financemanagerdesktop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CategoryDAO {
    private Connection connection;

    public void save(final Category entity) throws SQLException {
        final String sql = "INSERT INTO TB_CATEGORY(ID, DESCRIPTION) VALUES (CATEGORY_SEQ.NextVal, ?)";

        try(final PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, entity.getDescription());
            stmt.executeUpdate();
        }
    }

    public void update(final Category entity) throws SQLException {
        final String sql = "UPDATE TB_CATEGORY SET DESCRIPTION = ? WHERE ID = ?";

        try(final PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, entity.getDescription());
            stmt.setLong(2, entity.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(final Long id) throws SQLException{
        final String sql = "DELETE FROM TB_CATEGORY WHERE ID = ?";

        try(final PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Category> listAll() throws SQLException{
        final String sql = "SELECT ID, DESCRIPTION FROM TB_CATEGORY";
        final List<Category> list = new ArrayList<>();

        try(final PreparedStatement stmt = connection.prepareStatement(sql)){
            final ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                final Category category = new Category();
                category.setId(rs.getLong("ID"));
                category.setDescription(rs.getString("DESCRIPTION"));
                list.add(category);
            }
        }

        return list;
    }
}