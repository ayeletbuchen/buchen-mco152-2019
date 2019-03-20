package buchen.golf;

//import com.sun.tools.corba.se.idl.constExpr.BooleanOr;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;

public class GolfFrame extends JFrame {

    public static final int WIDTH = 1450;
    public static final int HEIGHT = 800;

    public GolfFrame() {
        setTitle("Touro Golf");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        GolfCourseComponent golfCourseComponent = new GolfCourseComponent();
        root.add(golfCourseComponent, BorderLayout.CENTER);

        setContentPane(root);
    }
}
