package com.alasdeplata.services;

import java.util.List;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.dto.aiinteraction.AiInteractionUpdateRequest;

public interface AiInteractionService {

    List<AiInteractionResponse> getAllAiInteractions();

    AiInteractionResponse getAiInteractionById(Long id);

    AiInteractionResponse createAiInteraction(AiInteractionRequest data);

    AiInteractionResponse updateAiInteraction(Long id, AiInteractionUpdateRequest data);

    void deleteAiInteraction(Long id);
}
