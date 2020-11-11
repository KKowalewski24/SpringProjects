package pl.kkowalewski.corsrestfulservice.model;

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

    public String getContent() {
        return content;
    }
}
