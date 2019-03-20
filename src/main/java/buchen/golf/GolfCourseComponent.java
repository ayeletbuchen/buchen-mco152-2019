package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class GolfCourseComponent extends JComponent {

    private static final int BALL_SIZE = 15;
    private static final int BALL_START = 30;
    private static final int FLAG_X = 770;
    private static final int POLE_WIDTH = 5;
    private static final int FLAG_WIDTH = 45;
    private static final int POLE_HEIGHT = 175;
    private static final int FLAG_HEIGHT = 30;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int groundLevel = getHeight() - (getHeight() / 3);

        // Draw sky
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw ground
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, groundLevel, getWidth(), getHeight());

        // Draw ball
        graphics.setColor(Color.WHITE);
        graphics.fillOval(BALL_START, groundLevel - BALL_SIZE, BALL_SIZE, BALL_SIZE);

        // Draw flag pole
        graphics.setColor(Color.GRAY);
        graphics.fillRect(FLAG_X, groundLevel - POLE_HEIGHT, POLE_WIDTH, POLE_HEIGHT);

        // Draw flag
        graphics.setColor(Color.RED);
        graphics.fillPolygon(new int[] {FLAG_X, FLAG_X - FLAG_WIDTH, FLAG_X},
                new int[] {groundLevel - POLE_HEIGHT, groundLevel - 160, groundLevel - 145},3);
    }
}
