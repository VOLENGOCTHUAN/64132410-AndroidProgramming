package tiil.edu.project_quizzappmatchgrade3;

public class item {
    String name, chuthich;
    int image;

    public item(String name, String email, String phone, int image) {
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

    public String getEmail() {
        return chuthich;
    }

    public void setEmail(String email) {
        this.chuthich = email;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}