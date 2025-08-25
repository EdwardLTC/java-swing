package org.example.data.repositories.product;

import org.example.data.models.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Repository interface for managing Product entities.
 * Provides basic CRUD operations for Product objects.
 */
public interface ProductRepository {

    /**
     * Finds a product by its unique identifier.
     *
     * @param id the product ID
     * @return the Product with the given ID, or null if not found
     * @throws SQLException if a data access error occurs
     */
    Product findById(int id) throws SQLException;

    /**
     * Retrieves all products.
     *
     * @return a list of all Products
     * @throws SQLException if a data access error occurs
     */
    List<Product> findAll() throws SQLException;

    /**
     * Saves a new product to the database.
     *
     * @param product the Product to save
     * @throws SQLException if a data access error occurs
     */
    void save(Product product) throws SQLException;

    /**
     * Updates an existing product in the database.
     *
     * @param product the Product to update
     * @throws SQLException if a data access error occurs
     */
    void update(Product product) throws SQLException;

    /**
     * Deletes a product from the database.
     *
     * @param id the ID of the Product to delete
     * @throws SQLException if a data access error occurs
     */
    void delete(int id) throws SQLException;
}