package com.example.speakerdiarizationbackend.dtos;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class TimeConfig {
    private static final String timeFormat = "HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(timeFormat);
            builder.serializers(new LocalTimeSerializer(DateTimeFormatter.ofPattern(timeFormat)));
        };
    }
}
