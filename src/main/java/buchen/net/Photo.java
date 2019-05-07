package buchen.net;

public class Photo {

    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
