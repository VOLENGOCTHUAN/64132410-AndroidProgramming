package tiil.edu.project_quizzappmatchgrade3;

public class item {
    String name, chuthich;
    int image;

    public item(String name, String chuthich, int image) {
        this.name = name;
        this.chuthich = chuthich;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChuthich() {
        return chuthich;
    }

    public void setChuthich(String chuthich) {
        this.chuthich = chuthich;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}