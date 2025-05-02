package com.alasdeplata.dto.aiinteraction;

import com.alasdeplata.enums.InteractionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AiInteractionRequest(
                @NotNull Long userId,
                @NotNull InteractionType interactionType,
                @NotBlank String message) {

}
