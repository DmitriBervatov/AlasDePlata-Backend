package com.alasdeplata.services.impl;

import org.springframework.stereotype.Service;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.dto.aiinteraction.AiInteractionUpdateRequest;
import com.alasdeplata.mapper.AiInteractionMapper;
import com.alasdeplata.models.AiInteraction;
import com.alasdeplata.repository.AiInteractionRepository;
import com.alasdeplata.services.AiInteractionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiInteractionServiceImpl implements AiInteractionService {

    private final AiInteractionRepository aiInteractionRepository;
    private final AiInteractionMapper aiInteractionMapper;

    @Override
    public AiInteractionResponse createAiInteraction(AiInteractionRequest data) {
        AiInteraction aiInteraction = aiInteractionMapper.toEntity(data);
        aiInteractionRepository.save(aiInteraction);
        return aiInteractionMapper.toResponse(aiInteraction);
    }

    @Override
    public AiInteractionResponse updateAiInteraction(Long id, AiInteractionUpdateRequest data) {
        AiInteraction aiInteraction = aiInteractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AiInteraction not found"));
        aiInteractionMapper.updateAiInteractionFromDto(data, aiInteraction);
        aiInteractionRepository.save(aiInteraction);
        return aiInteractionMapper.toResponse(aiInteraction);
    }

    @Override
    public AiInteractionResponse getAiInteractionById(Long id) {
        return aiInteractionRepository.findById(id).map(aiInteractionMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("AiInteraction not found"));
    }

    @Override
    public void deleteAiInteraction(Long id) {
        aiInteractionRepository.deleteById(id);
    }

}
