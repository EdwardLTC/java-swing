package org.example.data.repositories.product;

import com.j256.ormlite.dao.Dao;
import org.example.data.models.Product;

import javax.inject.Inject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final Dao<Product, Integer> productDao;

    @Inject
    public ProductRepositoryImpl(Dao<Product, Integer> productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product findById(int id) throws SQLException {
        return productDao.queryBuilder()
                .where()
                .eq("id", id)
                .and()
                .isNull("deleted_at")
                .queryForFirst();
    }

    @Override
    public List<Product> findAll() throws SQLException {
        return productDao.queryBuilder()
                .where()
                .isNull("deleted_at")
                .query();
    }

    @Override
    public void save(Product product) throws SQLException {
        productDao.create(product);
    }

    @Override
    public void update(Product product) throws SQLException {
        productDao.update(product);
    }

    @Override
    public void delete(int id) throws SQLException {
        Product product = findById(id);
        if (product != null) {
            product.setDeletedAt(new Date(System.currentTimeMillis()));
            productDao.update(product);
        }
    }
}
