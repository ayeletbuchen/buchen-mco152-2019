package buchen.golf;

import buchen.physics.Projectile;

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
    private final int[] cloudWidth = new int[] {130, 150, 150, 195, 200, 145, 175, 160, 150, 225, 187, 145};
    private final int[] cloudHeight = new int[] {55, 75, 75, 120, 125, 70, 100, 85, 75, 150, 112, 70};
    private final Image cloud = new ImageIcon("cloud.png").getImage();
    private final Image golfBall = new ImageIcon("golf_ball.png").getImage();
    private final ImageIcon grassIcon = new ImageIcon("grass.png");
    private final int grassWidth = grassIcon.getIconWidth() / 10;
    private final int grassHeight = grassIcon.getIconHeight() / 10;
    private final Image grass = grassIcon.getImage();
    private final Color lightBrown = new Color(186, 127, 61);
    private final Color mediumBrown = new Color(135, 79, 16);
    private final Color darkBrown = new Color(81, 43, 0);
    private final Color[] groundColors = new Color[] {Color.GREEN, lightBrown, mediumBrown, darkBrown};
    private int groundLevel;
    private Projectile projectile = new Projectile(0, 0);
    //84.85, 45


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        groundLevel = getHeight() - (getHeight() / 3);

        drawSky(graphics);
        drawClouds(graphics);
        drawGround(graphics);
        drawGrass(graphics, 0, groundLevel - grassHeight);
        drawBall(graphics);
        drawFlagPole(graphics);
        drawFlag(graphics);
        repaint();
    }

    public void goClicked(double velocity, double degrees) {
        projectile = new Projectile(velocity, degrees);
    }

    private void drawSky(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawGround(Graphics graphics) {
        int[] groundY = new int[] {groundLevel, groundLevel + 60, groundLevel + 100, groundLevel + 180};
        int[] groundHeight = new int[] {getHeight(), 50, 80, getHeight()};

        for (int i = 0; i < groundColors.length; i++) {
            graphics.setColor(groundColors[i]);
            graphics.fillRect(0, groundY[i], getWidth(), groundHeight[i]);
        }
    }

    private void drawBall(Graphics graphics) {
        graphics.drawImage(golfBall,
                BALL_START + (int) projectile.getX(), groundLevel - BALL_SIZE - (int) projectile.getY(), BALL_SIZE, BALL_SIZE, null);
        if (projectile.getY() >= 0) {
            projectile.addTime(0.02);
        }
    }

    private void drawFlagPole(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(FLAG_X, groundLevel - POLE_HEIGHT, POLE_WIDTH, POLE_HEIGHT);
    }

    private void drawFlag(Graphics graphics) {
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

    private void drawClouds(Graphics graphics) {
        int[] cloudY = new int[] {
                groundLevel - 470,
                groundLevel - 230,
                groundLevel - 200,
                groundLevel - 445,
                groundLevel - 340,
                groundLevel - 460,
                groundLevel - 240,
                groundLevel - 235,
                groundLevel - 490,
                groundLevel - 470,
                groundLevel - 455,
                groundLevel - 290};

        for (int i = 0; i < cloudX.length; i++) {
            int startX = (int) cloudX[i] % GolfFrame.WIDTH;
            int endX = startX + cloudWidth[i];
            if (startX + cloudWidth[i] > GolfFrame.WIDTH) {
                //graphics.drawImage(cloud, );
            }
            graphics.drawImage(cloud, startX, cloudY[i], cloudWidth[i], cloudHeight[i], null);
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
