package com.example.emailwriter.service;

import com.example.emailwriter.dto.EmailRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient webClient) {
        this.webClient = webClient;
    }


    public String generateEmailReply(EmailRequest emailRequest){
        // Build the prompt
        String prompt = buildPrompt(emailRequest);
        // Craft a request
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] {
                        Map.of( "parts",  new Object[] {
                                Map.of("text", prompt)
                        })
                }
        );
        // Do request and get response
        // Use webflux as httpClient

        String response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-type", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Extract extractResponseContent abd return
        
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);
            return jsonNode.path("candidates").get(0)
                    .path("contents").get(0)
                    .path("")
        } catch (Exception e) {
            return "Error processing response" + e.getMessage();
        }

    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content. Please don't generate a subject line. ");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append(" Tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

}
