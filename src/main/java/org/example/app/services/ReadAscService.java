package org.example.app.services;

import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadAscService {

    List<User> list;

    public String getData() {
        return formDataToString(readData());
    }

    private List<User> readData() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            // Допишите SQL-запрос
            String sql = "SELECT name,email FROM " + Constants.TABLE_NAME;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new User(
                                rs.getString("name"),
                                rs.getString("email")
                        )
                );
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    private String formDataToString(List<User> users) {

        if (users != null) {
            if (!users.isEmpty()) {
                int count = 0;
                String str;

                StringBuilder stringBuilder = new StringBuilder();

                for (User user : users) {
                    count++;
                    str = count + ") " + user.getName() + " "
                            + " " + user.getEmail() + "\n";
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            } else
                return Constants.DATA_ABSENT_MSG;
        } else
            return Constants.DB_ABSENT_MSG;
    }
}
