import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Databasegui {
    public static void main(String[] args) {
        JFrame f = new JFrame("Database Operations");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(3);
        JTextArea displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display");
        JButton exitButton = new JButton("Exit");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                if (!name.isEmpty() && !age.isEmpty()) {
                    displayArea.setText("Added: " + name + ", Age: " + age);
                } else {
                    displayArea.setText("Enter both name and age.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    displayArea.setText("Deleted record for " + name);
                } else {
                    displayArea.setText("Enter a name to delete.");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("1: Alice, 20\n2: Bob, 22\n3: Charlie, 19");
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        f.add(nameLabel);
        f.add(nameField);
        f.add(ageLabel);
        f.add(ageField);
        f.add(addButton);
        f.add(deleteButton);
        f.add(displayButton);
        f.add(exitButton);
        f.add(scrollPane);

        f.setVisible(true);
    }
}