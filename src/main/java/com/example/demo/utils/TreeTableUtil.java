package com.example.demo.utils;

import com.example.demo.entity.Human;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class TreeTableUtil {

    // Returns Name TreeTableColumn
    public static TreeTableColumn<Human, String> getNameColumn() {
        TreeTableColumn<Human, String> firstNameCol = new TreeTableColumn<>("name");
        firstNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        return firstNameCol;
    }

    // Returns Age TreeTableColumn
    public static TreeTableColumn<Human, String> getLastAgeColumn() {
        TreeTableColumn<Human, String> lastNameCol = new TreeTableColumn<>("age");
        lastNameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("age"));
        return lastNameCol;
    }

    // Returns Birth Date TreeTableColumn
    public static TreeTableColumn<Human, String> getBirthDateColumn() {
        TreeTableColumn<Human, String> birthDateCol = new TreeTableColumn<>("birthday");
        birthDateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthday"));
        return birthDateCol;
    }

}
