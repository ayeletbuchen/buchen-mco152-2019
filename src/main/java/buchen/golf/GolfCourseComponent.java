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
    private double cloud0X = 0;
    private double cloud1X = 130;
    private double cloud2X = 30;
    private double cloud3X = 170;
    private double cloud4X = 350;
    private double cloud5X = 570;
    private double cloud6X = 650;
    private double cloud7X = 800;
    private double cloud8X = 1075;
    private double cloud9X = 950;
    private double cloud10X = 1125;
    private double cloud11X = 1225.0;

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
        repaint();
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

        graphics.drawImage(cloud, (int) cloud0X % GolfFrame.WIDTH, groundLevel - 470, 130, 55, null);

        graphics.drawImage(cloud, (int) cloud1X % GolfFrame.WIDTH, groundLevel - 230, 150, 75, null);
        graphics.drawImage(cloud, (int) cloud2X % GolfFrame.WIDTH,groundLevel - 200,150,75,null);


        graphics.drawImage(cloud, (int) cloud3X % GolfFrame.WIDTH, groundLevel - 445, 195, 120, null);

        graphics.drawImage(cloud, (int) cloud4X % GolfFrame.WIDTH, groundLevel - 340, 200, 125, null);

        graphics.drawImage(cloud, (int) cloud5X % GolfFrame.WIDTH, groundLevel - 460, 145, 70, null);


        graphics.drawImage(cloud, (int) cloud6X % GolfFrame.WIDTH, groundLevel - 240, 175, 100, null);
        graphics.drawImage(cloud, (int) cloud7X % GolfFrame.WIDTH, groundLevel - 235, 160, 85, null);


        graphics.drawImage(cloud, (int) cloud8X % GolfFrame.WIDTH, groundLevel - 490, 150, 75, null);
        graphics.drawImage(cloud, (int) cloud9X % GolfFrame.WIDTH, groundLevel - 470, 225, 150, null);
        graphics.drawImage(cloud, (int) cloud10X % GolfFrame.WIDTH, groundLevel - 455, 187, 112, null);


        graphics.drawImage(cloud, (int) cloud11X % GolfFrame.WIDTH, groundLevel - 290, 145, 70, null);

        cloud0X += 0.05;
        cloud1X += 0.05;
        cloud2X += 0.05;
        cloud3X += 0.05;
        cloud4X += 0.05;
        cloud5X += 0.05;
        cloud6X += 0.05;
        cloud7X += 0.05;
        cloud8X += 0.05;
        cloud9X += 0.05;
        cloud10X += 0.05;
        cloud11X += 0.05;
    }
}
