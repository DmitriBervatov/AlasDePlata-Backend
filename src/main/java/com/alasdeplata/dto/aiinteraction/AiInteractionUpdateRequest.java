package com.alasdeplata.dto.aiinteraction;

import com.alasdeplata.enums.InteractionType;

public record AiInteractionUpdateRequest(
        Long userId,
        InteractionType interactionType,
        String message) {

}
