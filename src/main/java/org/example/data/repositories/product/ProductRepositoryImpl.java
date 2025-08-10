package org.example.data.repositories.product;

import com.j256.ormlite.dao.Dao;
import org.example.data.models.Product;

import javax.inject.Inject;

public class ProductRepositoryImpl implements ProductRepository {

    private final Dao<Product, Integer> productDao;

    @Inject
    public ProductRepositoryImpl(Dao<Product, Integer> userDao) {
        this.productDao = userDao;
    }
}
