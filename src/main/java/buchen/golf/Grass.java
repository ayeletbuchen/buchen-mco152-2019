package buchen.golf;

import javax.swing.*;
import java.awt.*;

public class Grass {
    protected final ImageIcon grassIcon;
    protected final int grassWidth;
    protected final int grassHeight;
    protected final Image image;

    public Grass(String filename) {
        grassIcon = new ImageIcon(filename);
        grassWidth = grassIcon.getIconWidth() / 10;
        grassHeight = grassIcon.getIconHeight() / 10;
        image = grassIcon.getImage();
    }
}
