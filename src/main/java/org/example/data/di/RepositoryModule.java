package org.example.data.di;

import dagger.Binds;
import dagger.Module;
import org.example.data.repositories.user.UserRepository;
import org.example.data.repositories.user.UserRepositoryImpl;

import javax.inject.Singleton;

@Module
public abstract class RepositoryModule {

    @Binds
    @Singleton
    public abstract UserRepository bindUserRepository(UserRepositoryImpl impl);
}