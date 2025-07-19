package org.example.data.repositories;

import org.example.data.annotations.AutoRepository;
import org.example.data.di.DaggerDataComponent;
import org.example.data.di.DataComponent;
import org.example.data.di.DatabaseModule;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

public class RepositoryFactory {
    private static RepositoryFactory instance;

    private final Map<Class<?>, Object> repositoryMap = new HashMap<>();

    private RepositoryFactory() {
        DataComponent dataComponent = DaggerDataComponent.builder()
                .databaseModule(new DatabaseModule())
                .build();

        for (Method method : DataComponent.class.getDeclaredMethods()) {
            AutoRepository anno = method.getAnnotation(AutoRepository.class);
            if (anno != null) {
                try {
                    Object repoInstance = method.invoke(dataComponent);
                    repositoryMap.put(anno.value(), repoInstance);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to init repository: " + method.getName(), e);
                }
            }
        }
    }

    public static void initializer() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
    }

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public <T> T getRepository(Class<T> repoClass) {
        if (!repositoryMap.containsKey(repoClass))
            throw new IllegalArgumentException("Repository not found for class: " + repoClass.getName());

        return repoClass.cast(repositoryMap.get(repoClass));
    }
}
