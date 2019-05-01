package buchen.net;

import io.reactivex.disposables.Disposable;
import javax.swing.*;
import java.awt.*;

public class PhotoListFrame extends JFrame {

    private final int width = 825;
    private final int height = 800;

    public PhotoListFrame() {
        setTitle("Photos");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        PhotoListComponent component = new PhotoListComponent();
        root.add(component.getComponent(), BorderLayout.CENTER);


        JsonPlaceHolderClient client = new JsonPlaceHolderClient();
        Disposable disposable = client.getPhotoList().subscribe(component::setPhotoList);

        setContentPane(root);
    }

    public static void main(String[] args) {

        new PhotoListFrame().setVisible(true);
    }
}
