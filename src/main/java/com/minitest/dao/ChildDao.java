package com.minitest.dao;

import com.minitest.model.child;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChildDao implements IChildDao {
    public static final String AddNewChild = "INSERT INTO Child(fullName, age, gender,idF) VALUES(?,?,?,?)";
    public static final String SELECT_FROM_CHILD = "SELECT * FROM Child";
    public static final String SelectWhereId = "SELECT idS,fullname,age,gender,idF FROM child where idS=?";
    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public List<child> displayAllChildren() {
        List<child> children = new ArrayList<>();
        try (
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CHILD);)
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idS");
                String fullname = resultSet.getString("fullName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                int idF = resultSet.getInt("idF");
                children.add(new child(id,fullname,age,gender,idF));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    @Override
    public void addNewChild(child child) throws SQLException {

        try (
                PreparedStatement statement = connection.prepareStatement(AddNewChild)
        ) {
            statement.setString(1, child.getFullname());
            statement.setInt(2, child.getAge());
            statement.setString(3, child.getGender());
            statement.setInt(4,child.getIdF());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public child getChildByIdS(int idS) {
        child child=null;
        try(
                PreparedStatement statement = connection.prepareStatement(SelectWhereId)
                ) {
            statement.setInt(1,idS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String fullname =resultSet.getString("fullname");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                int idF = resultSet.getInt("idF");
                child = new child(idS,fullname,age,gender,idF);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return child;
    }

    @Override
    public boolean editChild(child child) {
        boolean rowEdit = false;
        try(
                PreparedStatement statement = connection.prepareStatement("Update child SET fullname =? ,age=? , gender=?, idF=? where idS=?;")
                ) {
            statement.setString(1,child.getFullname());
            statement.setInt(2,child.getAge());
            statement.setString(3,child.getGender());
            statement.setInt(4,child.getIdF());
            statement.setInt(5,child.getIdS());
            rowEdit=statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowEdit;
    }
}
