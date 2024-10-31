package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models.ArticleEntity;
import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.repositories.ArticleRepository;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ArticlesAndConferencesDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticleDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.rabbit.MessageProducer;

@Service
public class ArticleServicelmpl implements IArticleService {

    private ArticleRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;
    private ConferencesService servicioConsumirObtencionConferencias;
    private final MessageProducer servicioEnviarCorreo;

    public ArticleServicelmpl(ArticleRepository servicioAccesoBaseDatos, ModelMapper modelMapper, ConferencesService servicioConsumirObtencionConferencias, MessageProducer servicioEnviarCorreo) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
        this.servicioConsumirObtencionConferencias = servicioConsumirObtencionConferencias;
        this.servicioEnviarCorreo = servicioEnviarCorreo;
    }

    @Override
    public List<ArticleDTO> findAll() {
        List<ArticleEntity> articuloEntity = this.servicioAccesoBaseDatos.findAll();
        List<ArticleDTO> articuloDTO = this.modelMapper.map(articuloEntity, new TypeToken<List<ArticleDTO>>() {
        }.getType());
        return articuloDTO;
    }

    @Override
    public ArticleDTO findById(Integer id) {
        ArticleEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
        if(objArticuloEntity == null){
            return null;
        }
        ArticleDTO articuloDTO = this.modelMapper.map(objArticuloEntity,  ArticleDTO.class);           
        return articuloDTO;
    }

    @Override
    public ArticleDTO save(ArticleDTO articulo) {
        ArticleEntity articuloEntity = this.modelMapper.map(articulo, ArticleEntity.class);
        ArticleEntity objArticuloEntity = this.servicioAccesoBaseDatos.save(articuloEntity);
        ArticleDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticleDTO.class);
        servicioEnviarCorreo.sendMessage(articuloDTO);
        return articuloDTO;
    }

    @Override
    public ArticleDTO update(Integer id, ArticleDTO articulo) {
        ArticleEntity articuloEntity = this.modelMapper.map(articulo, ArticleEntity.class);
        ArticleEntity articuloEntityActualizado = this.servicioAccesoBaseDatos.update(id, articuloEntity);
        ArticleDTO articuloDTO = this.modelMapper.map(articuloEntityActualizado, ArticleDTO.class);
        servicioEnviarCorreo.sendMessage(articuloDTO);
        return articuloDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public List<ConferenceDTO> ListarConferenciasDeArticulo(Integer idArticulo) {
        return this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
    }
    
    @Override
    public ArticlesAndConferencesDTO listarDatosArticulosConSusConferencias(Integer idArticulo) {
        List<ConferenceDTO> listaDeConferencias = this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
        ArticleEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(idArticulo);
        if(objArticuloEntity == null) {
            System.out.println("Ese articulo no existe");
            return null;
        }
        ArticleDTO objArticuloDTO = this.modelMapper.map(objArticuloEntity, ArticleDTO.class);
        ArticlesAndConferencesDTO objArticuloConferencia = new ArticlesAndConferencesDTO(objArticuloDTO, listaDeConferencias);
        return objArticuloConferencia;
    }

    @Override
    public boolean articleExists(Integer id) {
        return this.servicioAccesoBaseDatos.articleExist(id);
    }
}
