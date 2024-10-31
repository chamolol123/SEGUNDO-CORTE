package co.edu.unicauca.api_rest_conferencia.fachadaServices.services;

import java.util.List;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenceDTO;

public interface IConferenceService {
    public List<ConferenceDTO> findAll();
    public ConferenceDTO findById(Integer id);
    public ConferenceDTO save(ConferenceDTO conferencia);
    public ConferenceDTO update(ConferenceDTO conferencia);
    public Integer getCantMaxArticulos(Integer id);
    public List<ConferenceDTO> obtenerConferenciasDeArticulo(Integer idArticulo);
    public boolean delete(Integer id);
    public boolean existConference(Integer id);
    public Integer getCantArticulos(Integer id);
}
