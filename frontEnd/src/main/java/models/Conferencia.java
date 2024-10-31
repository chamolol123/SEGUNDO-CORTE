package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia {
    private Integer id;
    private String name; 
    private Date startDate; 
    private Date endDate; 
    private String place; 
    private int cantMaxArticles;
    private List<Articulo> articles; 

    public Conferencia(String name, Date startDate, Date endDate, String location, int cantMaxArticles) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = location;
        this.cantMaxArticles = cantMaxArticles;
        this.articles = new ArrayList<>();
        this.id = 0;
    }

    public Conferencia() {}

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCantMaxArticles() {
        return cantMaxArticles;
    }

    public void setCantMaxArticles(int cantMaxArticles) {
        this.cantMaxArticles = cantMaxArticles;
    }

    public List<Articulo> getArticles() {
        return articles;
    }

    public void setArticles(List<Articulo> articles) {
        this.articles = articles;
    }
    
    
    
    @Override
    public String toString() {
        return this.name; 
    }
}
