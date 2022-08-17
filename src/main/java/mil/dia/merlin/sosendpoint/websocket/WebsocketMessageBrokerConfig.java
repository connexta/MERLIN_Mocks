package mil.dia.merlin.sosendpoint.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableWebSocketMessageBroker
class WebsocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/topic/");
        config.setApplicationDestinationPrefixes("/sos");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/sensors")
                .withSockJS();
        registry.addEndpoint("/observations")
                .withSockJS();
    }

    @Bean
    public Map<Long, Set<WebSocketSession>> webSocketPool() {
        return new HashMap<>();
    }
}