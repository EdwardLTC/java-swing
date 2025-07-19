package org.example.data.di;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import dagger.Module;
import dagger.Provides;
import org.example.data.models.User;
import javax.inject.Singleton;

@Module
public class DaoModule {

    @Provides
    @Singleton
    Dao<User, Integer> provideUserDao(JdbcConnectionSource connectionSource) {
        try {
            return DaoManager.createDao(connectionSource, User.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to provide UserDao", e);
        }
    }
}
