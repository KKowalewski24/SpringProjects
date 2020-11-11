package pl.kkowalewski.exampleBeans;

public class FakeJmsBroker {

    /*------------------------ FIELDS REGION ------------------------*/
    private String user;
    private String password;
    private String url;

    /*------------------------ METHODS REGION ------------------------*/
    public FakeJmsBroker(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
