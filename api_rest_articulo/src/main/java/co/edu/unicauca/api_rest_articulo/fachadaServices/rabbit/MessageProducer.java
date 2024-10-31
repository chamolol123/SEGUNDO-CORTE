package co.edu.unicauca.api_rest_articulo.fachadaServices.rabbit;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticleDTO;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageProducer {
    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    /**
     * Constructor
     * @param amqpTemplate
     */
    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * Envia un mensaje a la cola
     * @param objArticuloCreado
     */
    public void sendMessage(ArticleDTO objArticuloCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objArticuloCreado);
        System.out.println("Datos del articulo enviado a la cola");
    }
}
