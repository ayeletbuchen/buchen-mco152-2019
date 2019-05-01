package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class Grass {
    private final ImageIcon grassIcon;
    private final int grassWidth;
    private final int grassHeight;
    private final Image image;

    public Grass(String filename) {
        grassIcon = new ImageIcon(filename);
        grassWidth = grassIcon.getIconWidth() / 10;
        grassHeight = grassIcon.getIconHeight() / 10;
        image = grassIcon.getImage();
    }

    public int getGrassWidth() {
        return grassWidth;
    }

    public int getGrassHeight() {
        return grassHeight;
    }

    public Image getImage() {
        return image;
    }
}
