package com.alasdeplata.dto.aiinteraction;

import com.alasdeplata.enums.InteractionType;

public record AiInteractionRequest(
        Long userId,
        InteractionType interactionType,
        String message) {

}
