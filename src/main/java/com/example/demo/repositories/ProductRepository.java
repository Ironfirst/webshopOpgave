package com.example.demo.repositories;

import com.example.demo.model.ProductDtu;
import com.example.demo.util.DatabaseConnectionManager;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private Connection conn;

    public ProductRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    // denne metode opretter products gennem prepared statement med input parametre
    // og checker om metoden er kørt korrekt ved at tælle om product oprettet > 0
    public boolean create(ProductDtu productDtu) {
        String sql = "INSERT INTO webshop.products(pro_name, pro_price, pro_des) VALUES (?,?,?)";

        try{
            PreparedStatement psProducts = conn.prepareStatement(sql);

            psProducts.setString(1,productDtu.getName());
            psProducts.setLong(2,productDtu.getPrice());
            psProducts.setString(3,productDtu.getBeskrivelse());

            int rowsInserted = psProducts.executeUpdate();
            if(rowsInserted > 0) {
                System.out.println("product blev oprettet succesfully");
            }
            return true;
        }

        catch (SQLException throwables) {
            System.out.println("der skete en fejl ved oprettelse af product");
            throwables.printStackTrace();
        }
        return false;
    }


    public List<ProductDtu> readAll() {

        List<ProductDtu> allProducts = new ArrayList<>();

        try{
            PreparedStatement psProduct = conn.prepareStatement("SELECT * FROM webshop.products");
            ResultSet rs = psProduct.executeQuery();
            while (rs.next()) {
                ProductDtu tempProduct = new ProductDtu();

                tempProduct.setName(rs.getString(1));
                tempProduct.setPrice(rs.getLong(2));
                tempProduct.setBeskrivelse(rs.getString(3));
                allProducts.add(tempProduct);
            }
        }
        catch (SQLException throwables) {
            System.out.println("der gik noget galt ved readall metoden af products");
            throwables.printStackTrace();
        }
        return allProducts;
    }


    public boolean update(ProductDtu productDtu){
        String sql = "UPDATE webshop.products SET pro_name=?, pro_price=?, pro_des=? WHERE pro_id="+ productDtu.getId();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,productDtu.getName());
            ps.setLong(2,productDtu.getPrice());
            ps.setString(3,productDtu.getBeskrivelse());

            int rowsUpdated = ps.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("Et product blev updateret korrekt");
            }
            return true;
        }

        catch (SQLException throwables) {
            System.out.println("noget gik galt da et product skulle updateres");
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean delete(int pro_id){
        String sql = "DELETE FROM webshop.products WHERE pro_id=?";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pro_id);

            int rowsDeleted = ps.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("et product blev slettet korrekt");
            }
        }
        catch (SQLException throwables) {
            System.out.println("der gik noget galt da et product skulle slettes check delete metoden i productRepos");
            throwables.printStackTrace();
        }
        return false;
    }
}
