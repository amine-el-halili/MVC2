package dao;

import connection.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao{
    private MyConnection connection;

    public ProductDaoImpl() throws SQLException, ClassNotFoundException {
        connection = MyConnection.getInstance();
    }

    @Override
    public void save(Product product) throws SQLException {
        connection.insert("Insert into produit values ('" + product.getName() + "')");
    }

    @Override
    public void update(Product product) throws SQLException {
        connection.insert("update produit set name = '" + product.getName() + "';");
    }

    @Override
    public void delete(Product product) throws SQLException {
        connection.insert("delete from produit where = '" + product.getName() + "';");
    }

    @Override
    public ArrayList<Product> getAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        ResultSet resultSet = connection.query("select * from produit");
        while (resultSet.next()) {
            Product product = new Product();
            product.setName(resultSet.getString("name"));

            products.add(product);
        }

        return products;
    }

    @Override
    public Product getByName(String name) throws SQLException {
        Product product = new Product();
        ResultSet resultSet = connection.query("select * from produit where name = '" + name + "';");

        resultSet.next();
        product.setName(resultSet.getString("name"));

        return product;
    }
}
