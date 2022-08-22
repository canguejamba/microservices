/**
 * Created by IntelliJ IDEA.
 * User: Cangue.Jamba
 * Project name: microservices
 */
package io.message.server;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;

    public void publish(Object playload, String exchange,String routingKey) {
        log.info("Publishing message to exchange {} with routing key {}. Payload: {}", exchange, routingKey, playload);
        amqpTemplate.convertAndSend(exchange, routingKey, playload);
        log.info("Published message to exchange {} with routing key {}. Payload: {}", exchange, routingKey, playload);

    }
}
