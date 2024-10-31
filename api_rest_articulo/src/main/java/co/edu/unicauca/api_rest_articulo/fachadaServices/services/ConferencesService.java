package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticlesAndConferencesDTO.ConferenceDTO;

import reactor.core.publisher.Mono;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConferencesService {

    @Autowired
    private WebClient.Builder webClientBuilder;
    
    public List<ConferenceDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        String url = "http://localhost:8000/api/conferencias/articulos/" + idArticulo;

        Mono<ConferenceDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenceDTO[].class);

        ConferenceDTO[] conferenciasArray = response.block();

        System.out.println("Conferencias obtenidas: ");
        for (ConferenceDTO conferencia : conferenciasArray) {
            System.out.println(conferencia.toString());
        }
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
