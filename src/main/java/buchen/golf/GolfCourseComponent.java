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
    private double[] cloudX = new double[] {0, 130, 30, 170, 350, 570, 650, 800, 1075, 950, 1125, 1225};
    private final Image cloud = new ImageIcon("cloud.png").getImage();
    private final Image golfBall = new ImageIcon("golf_ball.png").getImage();
    private final ImageIcon grassIcon = new ImageIcon("grass.png");
    private final int grassWidth = grassIcon.getIconWidth() / 10;
    private final int grassHeight = grassIcon.getIconHeight() / 10;
    private final Image grass = grassIcon.getImage();

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int groundLevel = getHeight() - (getHeight() / 3);

        drawSky(graphics);
        drawClouds(graphics, groundLevel);
        drawGround(graphics, groundLevel);
        drawGrass(graphics, 0, groundLevel - grassHeight);
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
        drawGreenGround(graphics, groundLevel);
        drawLightBrownGround(graphics, groundLevel);
        drawMediumBrownGround(graphics, groundLevel);
        drawDarkBrownGround(graphics, groundLevel);
    }

    private void drawGreenGround(Graphics graphics, int groundLevel) {
        graphics.setColor(Color.GREEN);
        graphics.fillRect(0, groundLevel, getWidth(), getHeight());
    }

    private void drawLightBrownGround(Graphics graphics, int groundLevel) {
        graphics.setColor(new Color(186, 127, 61));
        graphics.fillRect(0, groundLevel + 60, getWidth(), 50);
    }

    private void drawMediumBrownGround(Graphics graphics, int groundLevel) {
        graphics.setColor(new Color(135, 79, 16));
        graphics.fillRect(0, groundLevel + 100, getWidth(), 80);
    }

    private void drawDarkBrownGround(Graphics graphics, int groundLevel) {
        graphics.setColor(new Color(81,43,0));
        graphics.fillRect(0, groundLevel + 180, getWidth(), getHeight());
    }

    private void drawBall(Graphics graphics, int groundLevel) {
        graphics.drawImage(golfBall,
                BALL_START, groundLevel - BALL_SIZE, BALL_SIZE, BALL_SIZE, null);
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
        graphics.drawImage(cloud, (int) cloudX[0] % GolfFrame.WIDTH, groundLevel - 470, 130, 55, null);

        graphics.drawImage(cloud, (int) cloudX[1] % GolfFrame.WIDTH, groundLevel - 230, 150, 75, null);
        graphics.drawImage(cloud, (int) cloudX[2] % GolfFrame.WIDTH,groundLevel - 200,150,75,null);


        graphics.drawImage(cloud, (int) cloudX[3] % GolfFrame.WIDTH, groundLevel - 445, 195, 120, null);

        graphics.drawImage(cloud, (int) cloudX[4] % GolfFrame.WIDTH, groundLevel - 340, 200, 125, null);

        graphics.drawImage(cloud, (int) cloudX[5] % GolfFrame.WIDTH, groundLevel - 460, 145, 70, null);


        graphics.drawImage(cloud, (int) cloudX[6] % GolfFrame.WIDTH, groundLevel - 240, 175, 100, null);
        graphics.drawImage(cloud, (int) cloudX[7] % GolfFrame.WIDTH, groundLevel - 235, 160, 85, null);


        graphics.drawImage(cloud, (int) cloudX[8] % GolfFrame.WIDTH, groundLevel - 490, 150, 75, null);
        graphics.drawImage(cloud, (int) cloudX[9] % GolfFrame.WIDTH, groundLevel - 470, 225, 150, null);
        graphics.drawImage(cloud, (int) cloudX[10] % GolfFrame.WIDTH, groundLevel - 455, 187, 112, null);


        graphics.drawImage(cloud, (int) cloudX[11] % GolfFrame.WIDTH, groundLevel - 290, 145, 70, null);

        for (int i = 0; i < cloudX.length; i++) {
            cloudX[i] += 0.05;
        }
    }

    private void drawGrass(Graphics graphics, int xPosition, int yPosition) {
        graphics.drawImage(grass, xPosition, yPosition, grassWidth, grassHeight, null);
        int imageXEnd = xPosition + grassWidth;
        if (imageXEnd < GolfFrame.WIDTH) {
            drawGrass(graphics, imageXEnd, yPosition);
        }
    }
}
