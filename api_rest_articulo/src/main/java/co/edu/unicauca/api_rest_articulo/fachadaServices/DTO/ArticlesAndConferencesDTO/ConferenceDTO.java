package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConferenceDTO {
    private int id; 
    private String name; 
    private Date startDate; 
    private Date endDate;
    private String place;
    private int cantMaxArticles; 

    public ConferenceDTO() {
    }

    @Override
    public String toString() {
        return "ConferenciaDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + place + '\'' +
                ", cantMaxArticulos=" + cantMaxArticles +
                '}';
    }
}
