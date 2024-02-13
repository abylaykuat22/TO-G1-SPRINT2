package db;

import model.City;
import model.Country;
import model.Item;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DbManager {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/TO2024G1?currentSchema=sprint2",
                    "postgres",
                    "postgres"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            var statement = connection.prepareStatement(
                    "SELECT * FROM ITEMS"
            );
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("ID"));
                item.setName(resultSet.getString("NAME"));
                item.setDescription(resultSet.getString("DESCRIPTION"));
                item.setPrice(resultSet.getDouble("PRICE"));
                items.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static String auth(String email, String password) {
        User user = getUserByEmail(email);
        if (user == null) {
            return "emailError";
        }

        if (!Objects.equals(user.getPassword(), password)) {
            return "passwordError";
        }

        return "success";
    }

    public static User getUserByEmail(String email) {
        User user = null;
        try {
            var statement = connection.prepareStatement(
                    "SELECT * FROM USERS " +
                            "WHERE EMAIL = ?"
            );
            statement.setString(1, email);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setEmail(email);
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setFullName(resultSet.getString("FULL_NAME"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            var statement = connection.prepareStatement(
                    "SELECT u.id, u.full_name, u.email, u.city_id, c.name, c.code, c.country_id, co.name AS country_name, co.code AS country_code " +
                            "FROM sprint2.users u " +
                            "INNER JOIN cities c on c.id = u.city_id " +
                            "INNER JOIN countries co on co.id = c.country_id " +
                            "ORDER BY u.id"
            );
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setFullName(resultSet.getString("FULL_NAME"));

                City city = new City();
                city.setId(resultSet.getLong("CITY_ID"));
                city.setName(resultSet.getString("NAME"));
                city.setCode(resultSet.getString("CODE"));

                Country country = new Country();
                country.setId(resultSet.getLong("COUNTRY_ID"));
                country.setName(resultSet.getString("COUNTRY_NAME"));
                country.setCode(resultSet.getString("COUNTRY_CODE"));
                city.setCountry(country);

                user.setCity(city);
                users.add(user);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
