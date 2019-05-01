package buchen.net;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoListComponent {

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel bottomBar = new JPanel(new FlowLayout());
    private JLabel label = new JLabel("1");
    private JLabel imageLabel = new JLabel();
    private PhotoList photos;
    private int index;


    public PhotoListComponent() {
        addBackButton();
        addLabel();
        addNextButton();
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(bottomBar, BorderLayout.SOUTH);
    }

    private void addBackButton() {
        JButton back = new JButton("Previous");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousClicked();
            }
        });
        bottomBar.add(back);
    }

    private void addLabel() {
        bottomBar.add(label);
    }

    private void addNextButton() {
        JButton next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextClicked();
            }
        });
        bottomBar.add(next);
    }

    private void nextClicked() {
        if (index < photos.size() - 1) {
            index++;
            setPhoto();
        }
    }

    private void previousClicked() {
        if (index > 0) {
            index--;
            setPhoto();
        }
    }

    public JPanel getComponent() {
        return panel;
    }

    public void setPhotoList(PhotoList photos) {
        this.photos = photos;
        setPhoto();
    }

    private void setPhoto() {
        try {
            imageLabel.setIcon(new ImageIcon(new URL(photos.get(index).getUrl())));
            label.setText(String.valueOf(index + 1));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
