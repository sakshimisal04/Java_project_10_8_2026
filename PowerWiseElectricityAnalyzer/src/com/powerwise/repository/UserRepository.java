package com.powerwise.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.powerwise.db.DBConnection;
import com.powerwise.model.User;

public class UserRepository {


    // =========================================
    // CREATE - ADD USER
    // =========================================

    public void addUser(User user) {

        String sql = "INSERT INTO users "
                + "(user_name, email, phone, address, password) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getPassword());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User added successfully."
                );

            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =========================================
    // READ - VIEW ALL USERS
    // =========================================

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id")
                );

                user.setUserName(
                        rs.getString("user_name")
                );

                user.setEmail(
                        rs.getString("email")
                );

                user.setPhone(
                        rs.getString("phone")
                );

                user.setAddress(
                        rs.getString("address")
                );

                user.setPassword(
                        rs.getString("password")
                );

                users.add(user);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return users;
    }


    // =========================================
    // UPDATE - UPDATE USER
    // =========================================

    public void updateUser(User user) {

        String sql = "UPDATE users SET "
                + "user_name = ?, "
                + "email = ?, "
                + "phone = ?, "
                + "address = ?, "
                + "password = ? "
                + "WHERE user_id = ?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    user.getUserName()
            );

            ps.setString(
                    2,
                    user.getEmail()
            );

            ps.setString(
                    3,
                    user.getPhone()
            );

            ps.setString(
                    4,
                    user.getAddress()
            );

            ps.setString(
                    5,
                    user.getPassword()
            );

            ps.setInt(
                    6,
                    user.getUserId()
            );

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User updated successfully."
                );

            } else {

                System.out.println(
                        "User not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // =========================================
    // DELETE - DELETE USER
    // =========================================

    public void deleteUser(int userId) {

        String sql =
                "DELETE FROM users WHERE user_id = ?";

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "User deleted successfully."
                );

            } else {

                System.out.println(
                        "User not found."
                );
            }

            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}