package com.example.speakerdiarizationbackend.controllers;

import com.example.speakerdiarizationbackend.dtos.AudioFileDTO;
import com.example.speakerdiarizationbackend.dtos.SpeakerDiarizationRequestDTO;
import com.example.speakerdiarizationbackend.dtos.SpeakerDiarizationResponseDTO;
import com.example.speakerdiarizationbackend.services.ApiService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/speakers")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping(value = {"/fileName"}, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Mono<ResponseEntity<SpeakerDiarizationResponseDTO>> getSpeakers(@PathVariable String fileName, @RequestPart MultipartFile audioFile) {
        AudioFileDTO audioFileDTO = new AudioFileDTO();
        audioFileDTO.setAudioFile(audioFile);

        SpeakerDiarizationRequestDTO requestDTO = new SpeakerDiarizationRequestDTO();
        requestDTO.setAudioFile(audioFileDTO);
        try {
            return apiService.getAll(requestDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
