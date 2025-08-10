package org.example.data.di;

import dagger.Component;
import org.example.data.annotations.AutoRepository;
import org.example.data.repositories.product.ProductRepository;

import javax.inject.Singleton;


@Singleton
@Component(modules = {DatabaseModule.class, DaoModule.class, RepositoryModule.class})
public interface DataComponent {

    @AutoRepository(ProductRepository.class)
    ProductRepository productRepository();
}
