package org.example.data.di;

import dagger.Binds;
import dagger.Module;
import org.example.data.repositories.product.ProductRepository;
import org.example.data.repositories.product.ProductRepositoryImpl;

import javax.inject.Singleton;

@Module
public abstract class RepositoryModule {

    @Binds
    @Singleton
    public abstract ProductRepository bindProductRepository(ProductRepositoryImpl impl);
}