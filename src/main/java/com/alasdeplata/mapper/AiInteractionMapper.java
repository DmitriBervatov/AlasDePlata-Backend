package com.alasdeplata.mapper;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.models.AiInteraction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AiInteractionMapper {
    AiInteractionResponse toResponse(AiInteraction aiInteraction);

    AiInteraction toEntity(AiInteractionRequest data);
}
