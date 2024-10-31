package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ArticlesAndConferencesDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticleDTO;

public interface IArticleService {
    public List<ArticleDTO> findAll();
    public ArticleDTO findById(Integer id);
    public ArticleDTO save(ArticleDTO articulo);
    public ArticleDTO update(Integer id, ArticleDTO articulo);
    public boolean delete(Integer id); 
    public List<ConferenceDTO> ListarConferenciasDeArticulo(Integer idArticulo);
    public ArticlesAndConferencesDTO listarDatosArticulosConSusConferencias(Integer idArticulo);
    public boolean articleExists(Integer id);
}
