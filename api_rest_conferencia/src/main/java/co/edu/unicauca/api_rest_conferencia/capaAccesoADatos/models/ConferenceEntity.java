package co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConferenceEntity {
    private Integer id; 
    private String name; 
    private Date startDate; 
    private Date endDate; 
    private String place; 
    private Integer cantMaxArticles; 
    private List<ArticleEntity> articles;

    public ConferenceEntity() {
    }
}
