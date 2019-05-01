package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class Cloud {

    private double xPosition;
    private final double yPosition;
    private final int width;
    private final int height;
    private final Image image = new ImageIcon("src/main/resources/cloud.png").getImage();

    public Cloud(double x, double y, int width, int height) {
        xPosition = x;
        yPosition = y;
        this.width = width;
        this.height = height;
    }

    public double getYPosition() {
        return yPosition;
    }

    public double getXPosition() {
        return xPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void incrementXPosition(double incrementValue) {
        xPosition += incrementValue;
    }
}
