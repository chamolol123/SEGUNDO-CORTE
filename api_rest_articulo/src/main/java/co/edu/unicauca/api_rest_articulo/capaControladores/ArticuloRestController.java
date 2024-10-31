package co.edu.unicauca.api_rest_articulo.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ArticlesAndConferencesDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ConferenceDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticleDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.services.IArticleService;

@RestController
@RequestMapping("/api")
public class ArticuloRestController {
    @Autowired
    private IArticleService articuloService;

    // Este servicio REST permite crear un articulo
    @PostMapping("/articulos")
    public ArticleDTO crearArticulo(@RequestBody ArticleDTO articulo) {
        ArticleDTO objArticulo = articuloService.save(articulo);
        return objArticulo;
    }

    @GetMapping("/articulos")
    public List<ArticleDTO> listarArticulos() {
        return articuloService.findAll();
    }

    @GetMapping("/articulos/{id}")
    public ArticleDTO consultarArticulo(@PathVariable Integer id) {
        ArticleDTO objArticulo = articuloService.findById(id);
        return objArticulo;
    }

    @PutMapping("/articulos/{id}")
    public ArticleDTO actualizarArticulo(@PathVariable Integer id, @RequestBody ArticleDTO articulo) {
        if(articuloService.findById(id) == null){
            return null;
        }
        ArticleDTO objArticulo = articuloService.update(id, articulo);
        return objArticulo;
    }

    @DeleteMapping("/articulos/{id}")
    public boolean eliminarArticulo(@PathVariable Integer id) {
        return articuloService.delete(id);
    }

    @GetMapping("/articulos2")
    public boolean consultarArticulo2(@RequestParam Integer id) {
        ArticleDTO objArticulo = articuloService.findById(id);
        if(objArticulo == null){
            return false;
        }
        return true;
    }

    @GetMapping("/articulos/conferencias/{idArticulo}")
    public List<ConferenceDTO> listarConferenciasDeArticulo(@PathVariable Integer idArticulo) {
        return articuloService.ListarConferenciasDeArticulo(idArticulo);
    }

    @GetMapping("/articulos/articulosyconferencias/{idArticulo}")
    public ArticlesAndConferencesDTO listarDatosArticulosConSusConferencias(@PathVariable Integer idArticulo) {
        return articuloService.listarDatosArticulosConSusConferencias(idArticulo);
    }

    @GetMapping("/articulos/existe/{id}")
    public boolean existeArticulo(@PathVariable Integer id) {
        return articuloService.findById(id) != null;
    }
}
