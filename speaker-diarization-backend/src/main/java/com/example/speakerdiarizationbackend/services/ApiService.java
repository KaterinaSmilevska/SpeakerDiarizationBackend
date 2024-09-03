package com.example.speakerdiarizationbackend.services;

import com.example.speakerdiarizationbackend.dtos.SpeakerDiarizationRequestDTO;
import com.example.speakerdiarizationbackend.dtos.SpeakerDiarizationResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ResponseEntity<SpeakerDiarizationResponseDTO>> getAll(SpeakerDiarizationRequestDTO requestDTO) throws IOException {

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        String fileName = requestDTO.getAudioFileDTO().getFileName();
        body.add("audioFile", requestDTO.getAudioFileDTO().getAudioFile().getResource());

        return webClient.post()
                .uri("/speakers/{fileName}", fileName)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(body))
                .retrieve()
                .bodyToMono(SpeakerDiarizationResponseDTO.class)
                .map(responseBody -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body(responseBody));
    }
}

