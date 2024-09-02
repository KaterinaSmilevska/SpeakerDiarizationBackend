package com.example.speakerdiarizationbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Speaker {
    @JsonProperty("speakerId")
    private int speakerId;
    @JsonProperty("segments")
    private List<SpeakerSegment> segments;

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public List<SpeakerSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<SpeakerSegment> segments) {
        this.segments = segments;
    }
}
