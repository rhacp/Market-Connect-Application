package com.market.connect.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.connect.models.dtos.OpenAIRequestDTO;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class OpenAIServiceImpl implements OpenAIService{

    private  final ObjectMapper objectMapper;

    public OpenAIServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String getOpenAIResponse(String prompt) {
        String jsonBody = null;
        try {
            jsonBody = objectMapper.writeValueAsString(new OpenAIRequestDTO("gpt-3.5-turbo", prompt));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonBody);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer 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")
                .post(requestBody)
                .build();

        String response = null;
        try {
            response = new OkHttpClient().newCall(request).execute().body().string();
            log.info("Request to OpenAI was executed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
