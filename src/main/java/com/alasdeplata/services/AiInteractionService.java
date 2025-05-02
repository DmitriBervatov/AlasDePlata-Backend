package com.alasdeplata.services;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.dto.aiinteraction.AiInteractionUpdateRequest;

public interface AiInteractionService {

    AiInteractionResponse createAiInteraction(AiInteractionRequest data);

    AiInteractionResponse updateAiInteraction(Long id, AiInteractionUpdateRequest data);

    AiInteractionResponse getAiInteractionById(Long id);

    void deleteAiInteraction(Long id);
}
