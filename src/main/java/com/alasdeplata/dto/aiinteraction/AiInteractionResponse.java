package com.alasdeplata.dto.aiinteraction;

import java.time.LocalDateTime;

import com.alasdeplata.enums.InteractionType;

public record AiInteractionResponse(
        Long id,
        Long userId,
        InteractionType interactionType,
        String message,
        String response,
        LocalDateTime createdAt) {

}
