package tiil.edu.volengocthuan_64132410_thigk_ltdt;

public class Item {
    String name;
    String time;
    int image;

    public Item(int image, String name, String time) {
        this.image = image;
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
