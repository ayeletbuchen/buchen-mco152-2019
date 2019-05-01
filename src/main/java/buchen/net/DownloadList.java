package buchen.net;

import io.reactivex.disposables.Disposable;
import java.io.IOException;


public class DownloadList {

    public static void main(String[] args) throws IOException {

        JsonPlaceHolderClient client = new JsonPlaceHolderClient();
        Disposable disposable = client.getPhotoList().subscribe(System.out::println);
    }
}
