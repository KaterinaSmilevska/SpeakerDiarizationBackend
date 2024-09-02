package com.example.speakerdiarizationbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@Getter
@Setter
public class SpeakerSegment {
    @JsonProperty("startTime")
    private LocalTime startTime;
    @JsonProperty("endTime")
    private LocalTime endTime;
    @JsonProperty("content")
    private String content;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
