package buchen.golf;

//import com.sun.tools.corba.se.idl.constExpr.BooleanOr;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;

public class GolfFrame extends JFrame {

    public GolfFrame() {
        setTitle("Touro Golf");
        setSize(800,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JLabel north = new JLabel(new ImageIcon("golf-tee.png"));
        root.add(north, BorderLayout.NORTH);

        JLabel south = new JLabel("SOUTH");
        south.setBackground(Color.MAGENTA);
        south.setOpaque(true);
        root.add(south, BorderLayout.SOUTH);

        JLabel west = new JLabel("WEST");
        west.setBackground(Color.CYAN);
        west.setOpaque(true);
        root.add(west, BorderLayout.WEST);

        JButton center = new JButton("CENTER");
        center.setBackground(Color.LIGHT_GRAY);
        center.setOpaque(true);
        center.addActionListener(this::printClick);
        root.add(center, BorderLayout.CENTER);

        setContentPane(root);
    }

    public void printClick(ActionEvent actionEvent) {
        System.out.println("CLICK");
    }
}
