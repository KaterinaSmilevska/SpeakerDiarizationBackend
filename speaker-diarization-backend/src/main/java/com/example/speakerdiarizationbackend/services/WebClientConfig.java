package com.example.speakerdiarizationbackend.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("https://virtserver.swaggerhub.com/KaterinaSmilevska/SpeakerDiarizationAPI/1.0")
                .build();
    }
}
