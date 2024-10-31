package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter 
public class ArticleDTO {
    private Integer id;
    private String title; 
    private String journal; 
    private String keywords;
    private Integer numAuthors;
    List<ConferenceDTO> conferencias;

    public ArticleDTO() {
    }
}
