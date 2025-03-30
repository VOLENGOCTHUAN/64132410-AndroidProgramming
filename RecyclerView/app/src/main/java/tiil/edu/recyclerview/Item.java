package tiil.edu.recyclerview;

public class Item {
    String name, email, phone;
    int image;

    public Item(String name, String email, String phone, int image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
