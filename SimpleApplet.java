import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class SimpleApplet extends Applet implements ActionListener {
private Button button;
private Label label;
@Override
public void init() {
// Set the layout
setLayout(new FlowLayout());
// Create a button
button = new Button("Click Me");
button.addActionListener(this); // Register the event listener
// Create a label
label = new Label("Button not clicked yet.");
// Add button and label to the applet
add(button);
add(label);
}
@Override
public void actionPerformed(ActionEvent e) {
// Update the label when the button is clicked
label.setText("Button clicked!");
}
}