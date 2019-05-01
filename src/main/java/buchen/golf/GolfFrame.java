package buchen.golf;

import javax.swing.*;
import java.awt.*;

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

        root.add(new InfoBar(golfCourseComponent).getInfoBar(), BorderLayout.SOUTH);

        setContentPane(root);
    }
}
