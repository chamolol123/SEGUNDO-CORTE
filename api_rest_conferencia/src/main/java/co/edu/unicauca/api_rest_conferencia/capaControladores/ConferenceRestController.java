package co.edu.unicauca.api_rest_conferencia.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenceDTO;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.services.IConferenceService;



@RestController
@RequestMapping("/api")
public class ConferenceRestController {
    @Autowired
    private IConferenceService conferenciaService;

    @PostMapping("/conferencias")
    public ConferenceDTO crearConferencia(@RequestBody ConferenceDTO conferencia) {
        ConferenceDTO objConferencia = conferenciaService.save(conferencia);
        return objConferencia;
    }

    @GetMapping("/conferencias")
    public List<ConferenceDTO> listarConferencias() {
        return conferenciaService.findAll();
    }

    @GetMapping("/conferencias/{id}")
    public ConferenceDTO consultarConferenciaPorId(@PathVariable Integer id) {
        ConferenceDTO objConferencia = conferenciaService.findById(id);
        if(objConferencia == null){
            return null;
        }
        return objConferencia;
    }

    @PutMapping("/conferencias/{id}")
    public ConferenceDTO actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenceDTO conferencia) {
        conferencia.setId(id);
        ConferenceDTO objConferencia = conferenciaService.update(conferencia);
        return objConferencia;
    }

    @DeleteMapping("/conferencias/{id}")
    public boolean eliminarConferencia(@PathVariable Integer id) {
        return conferenciaService.delete(id);
    }
    
    @GetMapping("/conferencias/cantMaxArticulos/{id}")
    public int consultarArticulosMaximos(@PathVariable Integer id) {
        return conferenciaService.getCantMaxArticulos(id);
    }
    
    @GetMapping("/conferencias/articulos/{id}")
    public List<ConferenceDTO> consultarArticulosDeConferencia(@PathVariable Integer id) {
        System.out.println("Consumiendo servicio de articulos de conferencia con id: " + id);
        return conferenciaService.obtenerConferenciasDeArticulo(id);
    }

    @GetMapping("/conferencias/existe/{id}")
    public boolean consultarConferencia(@PathVariable Integer id) {
        return conferenciaService.existConference(id);
    }

    @GetMapping("/conferencias/cantArticulos/{id}")
    public int consultarArticulosConferencia(@PathVariable Integer id) {
        return conferenciaService.getCantArticulos(id);
    }
}