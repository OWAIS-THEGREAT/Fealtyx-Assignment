package com.assignment.fealtyx.service;

import com.assignment.fealtyx.dto.OllamaRequest;
import com.assignment.fealtyx.dto.OllamaResponse;
import com.assignment.fealtyx.exception.OllamaUnavailableException;
import com.assignment.fealtyx.model.Student;
import com.assignment.fealtyx.utils.PromptBuilder;
import com.assignment.fealtyx.configuration.OllamaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OllamaService {

    private final RestTemplate restTemplate;
    private final OllamaConfig ollamaConfig;

    @Autowired
    public OllamaService(RestTemplate restTemplate, OllamaConfig config) {
        this.restTemplate = restTemplate;
        this.ollamaConfig = config;
    }

    public String getSummary(Student student) {
        String prompt = PromptBuilder.buildStudentSummaryPrompt(student);
        OllamaRequest request = new OllamaRequest("tinyllama", prompt, false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OllamaRequest> httpEntity = new HttpEntity<>(request, headers);

        try {
            log.info("Sending request to Ollama for student ID: {}", student.getId());
            ResponseEntity<OllamaResponse> response = restTemplate.exchange(
                    ollamaConfig.getOllamaApiUrl(),
                    HttpMethod.POST,
                    httpEntity,
                    OllamaResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().getResponse();
            } else {
                log.warn("Ollama responded with non-success status: {}", response.getStatusCode());
                throw new OllamaUnavailableException("Ollama returned non-success status: " + response.getStatusCode());
            }

        } catch (RestClientException ex) {
            log.error("Error communicating with Ollama service", ex);
            throw new OllamaUnavailableException("Ollama service unavailable");
        }
    }
}

