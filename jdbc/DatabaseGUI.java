import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class DatabaseGUI extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea displayArea;
    public DatabaseGUI() {
        setTitle("Database Operations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);
        add(new JLabel("Age:"));
        ageField = new JTextField(3);
        add(ageField);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        add(addButton);
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        add(deleteButton);
        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new DisplayButtonListener());
        add(displayButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
        displayArea = new JTextArea(10, 30);
        add(new JScrollPane(displayArea));
        setVisible(true);
    }
    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO people (name, age) VALUES (?, ?)")) {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.executeUpdate();
                displayArea.setText("Record added.");
            } catch (SQLException ex) {
                displayArea.setText("Error: " + ex.getMessage());
            }
        }
    }
    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("DELETE FROM people WHERE name = ?")) {
                stmt.setString(1, name);
                int rows = stmt.executeUpdate();
                displayArea.setText(rows > 0 ? "Record deleted." : "No such record.");
            } catch (SQLException ex) {
                displayArea.setText("Error: " + ex.getMessage());
            }
        }
    }
    private class DisplayButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM people")) {
                StringBuilder results = new StringBuilder();
                while (rs.next()) {
                    results.append(rs.getInt("id")).append(": ")
                           .append(rs.getString("name")).append(", ")
                           .append(rs.getInt("age")).append("\n");
                }
                displayArea.setText(results.toString());
            } catch (SQLException ex) {
                displayArea.setText("Error: " + ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        new DatabaseGUI();
    }
}