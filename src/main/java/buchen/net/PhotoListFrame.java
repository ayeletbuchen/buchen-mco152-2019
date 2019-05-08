package buchen.net;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.apache.commons.lang3.time.StopWatch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhotoListFrame extends JFrame {

    private final int width = 1200;
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
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Disposable disposable = client.getPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(component::setPhotoList);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                disposable.dispose();
            }
        });
        stopWatch.stop();
        System.out.println(stopWatch.getTime());

        setContentPane(root);
    }

    public static void main(String[] args) {

        new PhotoListFrame().setVisible(true);
    }
}
