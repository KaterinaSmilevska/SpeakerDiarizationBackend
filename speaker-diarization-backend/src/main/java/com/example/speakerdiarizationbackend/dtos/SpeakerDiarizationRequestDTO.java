package com.example.speakerdiarizationbackend.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpeakerDiarizationRequestDTO {
    AudioFileDTO audioFile;

    public AudioFileDTO getAudioFileDTO() {
        return audioFile;
    }

    public void setAudioFileDTO(AudioFileDTO audioFile) {
        this.audioFile = audioFile;
    }
}
