package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class Cloud {

    protected double xPosition;
    protected final double yPosition;
    protected final int width;
    protected final int height;
    protected final Image image = new ImageIcon("cloud.png").getImage();

    public Cloud(double x, double y, int width, int height) {
        xPosition = x;
        yPosition = y;
        this.width = width;
        this.height = height;
    }
}
