package co.edu.unicauca.api_rest_conferencia.fachadaServices.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.repositories.ConferenceRepository;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenceDTO;
import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ConferenceEntity;

import java.util.List;

@Service
public class ConferenceServicelmpl implements IConferenceService {

    @Autowired
    private ConferenceRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;

    public ConferenceServicelmpl(ConferenceRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
        this.modelMapper.typeMap(ConferenceEntity.class, ConferenceDTO.class).addMappings(mapper -> {
            mapper.map(ConferenceEntity::getArticles, ConferenceDTO::setArticles);
        });
    }

    @Override
    public List<ConferenceDTO> findAll() {
        List<ConferenceEntity> conferenciaEntity = this.servicioAccesoBaseDatos.findAll();
        List<ConferenceDTO> conferenciaDTO = this.modelMapper.map(conferenciaEntity, new TypeToken<List<ConferenceDTO>>() {
        }.getType());
        return conferenciaDTO;
    }

    @Override
    public ConferenceDTO findById(Integer id) {
        ConferenceEntity conferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
        if(conferenciaEntity == null){
            return null;
        }
        ConferenceDTO conferenciaDTO = this.modelMapper.map(conferenciaEntity,  ConferenceDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenceDTO save(ConferenceDTO conferencia) {
        ConferenceEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenceEntity.class);
        ConferenceEntity objConferenciaEntity = this.servicioAccesoBaseDatos.save(conferenciaEntity);
        ConferenceDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenceDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenceDTO update(ConferenceDTO conferencia) {
        ConferenceEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenceEntity.class);
        ConferenceEntity objConferenciaEntity = this.servicioAccesoBaseDatos.update(conferenciaEntity);
        if(objConferenciaEntity == null) {
            return null;
        }
        ConferenceDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenceDTO.class);
        return conferenciaDTO;
    }

    @Override
    public Integer getCantMaxArticulos(Integer id) {
        int cantArticulos = this.servicioAccesoBaseDatos.getCantMaxArticulos(id);
        return cantArticulos;
    }

    @Override
    public List<ConferenceDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        List<ConferenceEntity> listaConferencias = this.servicioAccesoBaseDatos.obtenerConferenciasDeArticulo(idArticulo);
        List<ConferenceDTO> conferenciasDTO = this.modelMapper.map(listaConferencias, new TypeToken<List<ConferenceDTO>>() {
        }.getType());
        return conferenciasDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public boolean existConference(Integer id) {
        return this.servicioAccesoBaseDatos.doesConferenceExist(id);
    }

    @Override
    public Integer getCantArticulos(Integer id) {
        return this.servicioAccesoBaseDatos.getNumArticles(id);
    }
    
}
