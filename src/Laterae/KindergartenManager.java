package Laterae;

import java.sql.*;
import java.util.List;

public class KindergartenManager {
    private Connection connection;

    public KindergartenManager() {
        try {
            // Initialize the database connection (replace with your actual database details)
            connection = DriverManager.getConnection("jdbc:postgresql://your-database-url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create tables for children and groups if they don't exist
    private void createTables() {
        try {
            Statement statement = connection.createStatement();
            String createChildTableSQL = "CREATE TABLE IF NOT EXISTS children (id SERIAL PRIMARY KEY, full_name TEXT, gender TEXT, age INT)";
            String createGroupTableSQL = "CREATE TABLE IF NOT EXISTS groups (id SERIAL PRIMARY KEY, name TEXT, number INT)";

            statement.execute(createChildTableSQL);
            statement.execute(createGroupTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a child to the database
    public void addChild(Child child) {
        try {
            String insertChildSQL = "INSERT INTO children (full_name, gender, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertChildSQL);
            preparedStatement.setString(1, child.getFullName());
            preparedStatement.setString(2, child.getGender());
            preparedStatement.setInt(3, child.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a group to the database
    public void addGroup(Group group) {
        try {
            String insertGroupSQL = "INSERT INTO groups (name, number) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertGroupSQL);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, group.getNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve children by group from the database
    public List<Child> getChildrenByGroup(Group group) {
        List<Child> children = new ArrayList<>();
        try {
            String selectChildrenSQL = "SELECT id, full_name, gender, age FROM children WHERE group_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectChildrenSQL);
            preparedStatement.setInt(1, group.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int childId = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                children.add(new Child(childId, fullName, gender, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    // Edit the details of a child
    public void editChild(Child child) {
        try {
            String updateChildSQL = "UPDATE children SET full_name = ?, gender = ?, age = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateChildSQL);
            preparedStatement.setString(1, child.getFullName());
            preparedStatement.setString(2, child.getGender());
            preparedStatement.setInt(3, child.getAge());
            preparedStatement.setInt(4, child.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Edit the details of a group
    public void editGroup(Group group) {
        try {
            String updateGroupSQL = "UPDATE groups SET name = ?, number = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateGroupSQL);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, group.getNumber());
            preparedStatement.setInt(3, group.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a child from the database
    public void removeChild(Child child) {
        try {
            String deleteChildSQL = "DELETE FROM children WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteChildSQL);
            preparedStatement.setInt(1, child.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a group from the database
    public void removeGroup(Group group) {
        try {
            String deleteGroupSQL = "DELETE FROM groups WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteGroupSQL);
            preparedStatement.setInt(1, group.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KindergartenManager manager = new KindergartenManager();

        // Create tables if they don't exist
        manager.createTables();

        // Example usage:
        Child child1 = new Child(0, "Alice", "Female", 5);
        manager.addChild(child1);

        Child child2 = new Child(0, "Bob", "Male", 4);
        manager.addChild(child2);

        Group group1 = new Group(0, "Bunnies", 1);
        manager.addGroup(group1);

        Group group2 = new Group(0, "Ducks", 2);
        manager.addGroup(group2);

        // Add children to groups
        group1.addChild(child1);
        group1.addChild(child2);

        // Retrieve children in a group
        List<Child> childrenInGroup1 = manager.getChildrenByGroup(group1);
        for (Child child : childrenInGroup1) {
            System.out.println(child.getFullName());
        }

        // Edit child details
        child1.setFullName("Alicia");
        manager.editChild(child1);

        // Remove a child from the database
        manager.removeChild(child2);

        // Close the database connection
        manager.closeConnection();
    }
}