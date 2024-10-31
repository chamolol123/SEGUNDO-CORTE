package models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Articulo {
    private Integer id;
    private String title;
    private String journal;
    private String keywords;
    private Integer numAuthors;
    
    public Articulo(String title, String journal, String keywords, Integer numAuthors) {
        this.title = title;
        this.journal = journal;
        this.keywords = keywords;
        this.numAuthors = numAuthors;
        this.id = 0;
    }

    public Articulo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getnumAuthors() {
        return numAuthors;
    }

    public void setCantAuthors(Integer numAuthors) {
        this.numAuthors = numAuthors;
    }
    
    
    
}