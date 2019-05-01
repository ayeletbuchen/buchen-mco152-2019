package buchen.net;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonPlaceHolderClient {

    private final JsonPlaceholderAPI api;

    public JsonPlaceHolderClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(JsonPlaceholderAPI.class);
    }

    public Observable<PhotoList> getPhotoList() {
        return api.getPhotoList();
    }
}
