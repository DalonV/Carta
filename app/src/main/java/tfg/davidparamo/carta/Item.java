package tfg.davidparamo.carta;

/**
 * Created by david on 23/03/2017.
 */

public class Item {
    private int image;
    private String url;
    public Item() {
        super();
    }

    public Item(int image, String url) {
        super();
        this.image = image;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
