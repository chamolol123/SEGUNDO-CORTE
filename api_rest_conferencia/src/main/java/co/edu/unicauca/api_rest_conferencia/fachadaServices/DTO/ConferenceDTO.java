package co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConferenceDTO {
    private Integer id; 
    private String name; 
    private Date startDate; 
    private Date endDate; 
    private String place;
    private Integer cantMaxArticles; 
    private List<ArticleDTO> articles;

    public ConferenceDTO() {
    }
}
