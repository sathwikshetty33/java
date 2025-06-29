import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing {
    public boolean clicked = false;
    public static void main(String[] args){
    swing s= new swing();
    JFrame j = new JFrame("Swings App");
    j.setSize(200,300);
    j.setLayout(new FlowLayout());
    ImageIcon i = new ImageIcon("image.png");
    JLabel ig = new JLabel(i);
    Button b = new Button("Click me!");
    JLabel l = new JLabel("Button not clicked Click to get image");
    b.addActionListener(new ActionListener() {
      
            public void actionPerformed(ActionEvent e){
                  if(!s.clicked){
            l.setText("Button clicked! Click again to remove image");
            j.add(ig);
            s.clicked = true;
             j.revalidate();
    j.repaint();
                         }
                    else{

                            l.setText("Button not clicked Click to get image");
                            j.remove(ig);
                        s.clicked = false;
                        j.revalidate();
    j.repaint();
            }
        }
   
    });
    j.add(b);
    j.add(l);
    j.setVisible(true);
}
}
