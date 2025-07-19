package org.example.data.repositories.user;

import org.example.data.models.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserRepository {
    /**
     * Finds all users in the database.
     *
     * @return a list of all users
     * @throws SQLException if there is an error accessing the database
     */
    ArrayList<User> findAll() throws SQLException;

    /**
     * Adds a new user to the database.
     *
     * @param user the user to add
     * @throws SQLException if there is an error accessing the database
     */
    void addUser(User user) throws SQLException;

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user to find
     * @return the user with the specified ID, or null if not found
     * @throws SQLException if there is an error accessing the database
     */
    User findUser(int id) throws SQLException;

    /**
     * Updates an existing user in the database.
     *
     * @param user the user with updated information
     * @throws SQLException if there is an error accessing the database
     */
    void updateUser(User user) throws SQLException;


    /**
     * Deletes a user from the database by their ID.
     *
     * @param id the ID of the user to delete
     * @throws SQLException if there is an error accessing the database
     */
    void deleteUser(int id) throws SQLException;
}