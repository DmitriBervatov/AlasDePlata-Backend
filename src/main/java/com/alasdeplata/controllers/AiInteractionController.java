package com.alasdeplata.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.dto.aiinteraction.AiInteractionUpdateRequest;
import com.alasdeplata.services.AiInteractionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/ai-interactions")
@RequiredArgsConstructor
public class AiInteractionController {

    private final AiInteractionService aiInteractionService;

    @GetMapping
    public ResponseEntity<List<AiInteractionResponse>> getAllAiInteractions() {
        return ResponseEntity.ok(aiInteractionService.getAllAiInteractions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AiInteractionResponse> getAiInteractionById(@PathVariable Long id) {
        return ResponseEntity.ok(aiInteractionService.getAiInteractionById(id));
    }

    @PostMapping
    public ResponseEntity<AiInteractionResponse> createAiInteraction(@RequestBody @Valid AiInteractionRequest data) {
        return ResponseEntity.ok(aiInteractionService.createAiInteraction(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AiInteractionResponse> updateAiInteraction(@PathVariable Long id,
            @RequestBody @Valid AiInteractionUpdateRequest data) {
        return ResponseEntity.ok(aiInteractionService.updateAiInteraction(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAiInteraction(@PathVariable Long id) {
        aiInteractionService.deleteAiInteraction(id);
        return ResponseEntity.noContent().build();
    }

}
