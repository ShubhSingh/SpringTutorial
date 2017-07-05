package tutorial10.springjdbc.annotation.model;

public class Offer {

    private Integer id;
    private String name;
    private String email;
    private String text;

    public Offer() {
    }

    public Offer(Integer id, String name, String email, String text) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
