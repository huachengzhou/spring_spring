package com.socket;

import com.socket.ince.ChatHandshakeInterceptor;
import com.socket.webSocket.ChatMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatMessageHandler(),"/websocket/chatMessageServer.do").addInterceptors(new ChatHandshakeInterceptor());
        registry.addHandler(chatMessageHandler(), "/sockjs/chatMessageServer.do").addInterceptors(new ChatHandshakeInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler chatMessageHandler(){
        return new ChatMessageHandler();
    }
}
