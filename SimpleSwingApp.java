import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleSwingApp {
public static void main(String[] args) {
// Create the frame
JFrame frame = new JFrame("Simple Swing App");
frame.setSize(300, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());
// Create a button
JButton button = new JButton("Click Me");
// Create a label
JLabel label = new JLabel("Button not clicked yet.");
// Add an action listener to the button
button.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
label.setText("Button clicked!");
}
});
// Add button and label to the frame
frame.add(button);
frame.add(label);
// Set the frame visibility
frame.setVisible(true);
}
}