package Model;

public class Mail {
    private final String mail;
    private final Integer id;

    public Integer getId() {
        return id;
    }

    public Mail(Integer id, String mail) {
        this.mail = mail;
        this.id = id;
    }
    
    public String getMail() {
        return mail;
    }
}
