package org.example;

import View.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        SwingUtilities.invokeLater(() ->{
            userView.init();
        });


    }
}