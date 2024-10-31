package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticleDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ArticlesAndConferencesDTO {
    private ArticleDTO objArticuloDTO; 
    private List<ConferenceDTO> conferencias; 
}
