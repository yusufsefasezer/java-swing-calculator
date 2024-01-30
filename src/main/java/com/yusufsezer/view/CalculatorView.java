package com.yusufsezer.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {

    private JTextField displayTextField;

    public CalculatorView() {
        setTitle("Java Swing Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
    }

    public void setDisplayText(String displayText) {
        displayTextField.setText(displayText);
    }

    public void createDisplayText(GridBagConstraints gridBagConstraints) {
        displayTextField = new JTextField();
        displayTextField.setEditable(false);
        displayTextField.setHorizontalAlignment(JTextField.RIGHT);

        Font font = new Font("Verdana", Font.PLAIN, 36);
        displayTextField.setFont(font);
        add(displayTextField, gridBagConstraints);
    }

    public void makebutton(String buttonText,
            GridBagConstraints gridBagConstraints,
            ActionListener actionListener) {
        JButton newButton = new JButton(buttonText);
        newButton.addActionListener(actionListener);
        add(newButton, gridBagConstraints);
    }

}
