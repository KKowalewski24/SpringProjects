package pl.kkowalewski.restfulactuator.model;

public class Greeting {

    /*------------------------ FIELDS REGION ------------------------*/
    private Long id;
    private String content;

    /*------------------------ METHODS REGION ------------------------*/
    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
