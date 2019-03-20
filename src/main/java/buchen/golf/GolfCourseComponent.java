package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class GolfCourseComponent extends JComponent {

    private static final int BALL_SIZE = 15;
    private static  int BALL_START = 30;
    private static final int FLAG_X = 770;
    private static final int POLE_WIDTH = 5;
    private static final int POLE_HEIGHT = 175;
    private static final int FLAG_WIDTH = 45;
    private static final int FLAG_HEIGHT = 30;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int groundLevel = getHeight() - (getHeight() / 3);

        drawSky(graphics);
        drawClouds(graphics, groundLevel);
        drawGround(graphics, groundLevel);
        drawBall(graphics, groundLevel);
        drawFlagPole(graphics, groundLevel);
        drawFlag(graphics, groundLevel);
    }

    private void drawSky(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawGround(Graphics graphics, int groundLevel) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, groundLevel, getWidth(), getHeight());
    }

    private void drawBall(Graphics graphics, int groundLevel) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(BALL_START, groundLevel - BALL_SIZE, BALL_SIZE, BALL_SIZE);
    }

    private void drawFlagPole(Graphics graphics, int groundLevel) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(FLAG_X, groundLevel - POLE_HEIGHT, POLE_WIDTH, POLE_HEIGHT);
    }

    private void drawFlag(Graphics graphics, int groundLevel) {
        graphics.setColor(Color.RED);
        graphics.fillPolygon(
                new int[] {
                        FLAG_X,
                        FLAG_X - FLAG_WIDTH,
                        FLAG_X},
                new int[] {
                        groundLevel - POLE_HEIGHT,
                        groundLevel - (POLE_HEIGHT - FLAG_HEIGHT / 2),
                        groundLevel - (POLE_HEIGHT - FLAG_HEIGHT)},
                3);
    }

    private void drawClouds(Graphics graphics, int groundLevel) {
        Image cloud = new ImageIcon("cloud.png").getImage();

        graphics.drawImage(cloud,130, groundLevel - 230, 150, 75, null);
        graphics.drawImage(cloud,30,groundLevel - 200,150,75,null);


        graphics.drawImage(cloud, 170, groundLevel - 445, 195, 120, null);

        graphics.drawImage(cloud, 350, groundLevel - 340, 200, 125, null);

        graphics.drawImage(cloud, 570, groundLevel - 460, 145, 70, null);


        graphics.drawImage(cloud, 650, groundLevel - 240, 175, 100, null);
        graphics.drawImage(cloud, 800, groundLevel - 235, 160, 85, null);


        graphics.drawImage(cloud, 1075, groundLevel - 490, 150, 75, null);
        graphics.drawImage(cloud, 950, groundLevel - 470, 225, 150, null);
        graphics.drawImage(cloud, 1125, groundLevel - 455, 187, 112, null);


        graphics.drawImage(cloud, 1225, groundLevel - 290, 145, 70, null);
    }
}
