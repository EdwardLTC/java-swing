package org.example.data.di;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import dagger.Module;
import dagger.Provides;
import org.flywaydb.core.Flyway;

import javax.inject.Singleton;

@Module
public class DatabaseModule {

    private final String dbUrl;

    public DatabaseModule() {
        String dbPath = "data/database.sqlite3";
        dbUrl = "jdbc:sqlite:" + dbPath;

        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, null, null)
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();

    }

    @Provides
    @Singleton
    JdbcConnectionSource provideConnectionSource() {
        try {
            return new JdbcConnectionSource(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create connection source", e);
        }

    }
}
