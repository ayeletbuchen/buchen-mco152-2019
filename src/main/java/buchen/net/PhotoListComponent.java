package buchen.net;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoListComponent {

    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel bottomBar = new JPanel(new FlowLayout());
    private JLabel label = new JLabel("1");
    private JLabel imageLabel = new JLabel();
    private PhotoList photos;
    private int index;
    private JList list;
    private DefaultListModel listModel;


    public PhotoListComponent() {
        addBackButton();
        addLabel();
        addNextButton();
        addList();
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(bottomBar, BorderLayout.SOUTH);
    }

    private void addBackButton() {
        JButton back = new JButton("Previous");
        back.addActionListener(e -> previousClicked());
        bottomBar.add(back);
    }

    private void addLabel() {
        bottomBar.add(label);
    }

    private void addNextButton() {
        JButton next = new JButton("Next");
        next.addActionListener(e -> nextClicked());
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
        addAllPhotos();
        setPhoto();
    }

    private void setPhoto() {
        try {
            imageLabel.setIcon(new ImageIcon(new URL(photos.get(index).getUrl())));
            label.setText(String.valueOf(index + 1));
            list.setSelectedIndex(index);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void addAllPhotos() {
        for (Photo photo : photos) {
            listModel.addElement(photo.getTitle());
        }
    }

    private void addList() {
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);

        JScrollPane scrollPane = new JScrollPane(list);

        list.addListSelectionListener(e -> {
            index = list.getSelectedIndex();
            setPhoto();
        });
        panel.add(scrollPane, BorderLayout.EAST);
    }
}
