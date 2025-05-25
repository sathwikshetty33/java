import java.awt.*;                      // For Frame, Button, Label, FlowLayout
import java.awt.event.*;               // For ActionListener, ActionEvent, WindowAdapter, WindowEvent

public class SimpleAWTEventHandling extends Frame implements ActionListener {
    private Button button;
    private Label label;

    public SimpleAWTEventHandling() {
        // Set the frame properties
        setTitle("Simple AWT Event Handling Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Create a button
        button = new Button("Click Me");
        button.addActionListener(this); // Register the event listener

        // Create a label
        label = new Label("Button not clicked yet.");

        // Add button and label to the frame
        add(button);
        add(label);

        // Add window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true); // Make the frame visible after adding components
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the label when the button is clicked
        label.setText("Button clicked!");
    }

    public static void main(String[] args) {
        new SimpleAWTEventHandling();
    }
}
