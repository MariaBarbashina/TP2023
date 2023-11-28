package View;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    private JTextArea text;
    private JButton sendButton;
    private JLabel info;
    private Controller controller;


    public UserView(Controller controller) throws HeadlessException{
        this.controller = controller;
    }

    public void init(){
        setSize(400, 300);
        text =  new JTextArea();
        sendButton = new JButton("Send");
        info = new JLabel("Info");

        add(text, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
        add(info, BorderLayout.NORTH);

        sendButton.addActionListener(e -> {
            int pin;
            String textPin = this.text.getText();
            pin = Integer.parseInt(textPin);
            info.setText("Got it " + pin + "Waiting...");

            //boolean result = controller.checkPin(pin);

            //String resultMessage;
            //if (result) {
                //resultMessage = "Right";
            //} else {
                //resultMessage = "Wrong, try again";
            //}
            //info.setText(resultMessage);


        });

        setVisible(true);
    }
}
