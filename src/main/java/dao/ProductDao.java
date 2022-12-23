package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    public void save(Product product) throws SQLException;
    public void update(Product product) throws SQLException;
    public void delete(Product product) throws SQLException;
    public ArrayList<Product> getAll() throws SQLException;
    public Product getByName(String name) throws SQLException;
}
