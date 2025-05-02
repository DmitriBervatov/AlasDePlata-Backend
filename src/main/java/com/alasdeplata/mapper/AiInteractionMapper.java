package com.alasdeplata.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alasdeplata.dto.aiinteraction.AiInteractionRequest;
import com.alasdeplata.dto.aiinteraction.AiInteractionResponse;
import com.alasdeplata.dto.aiinteraction.AiInteractionUpdateRequest;
import com.alasdeplata.models.AiInteraction;

@Mapper(componentModel = "spring")
public interface AiInteractionMapper {
    AiInteractionResponse toResponse(AiInteraction aiInteraction);

    AiInteraction toEntity(AiInteractionRequest data);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAiInteractionFromDto(AiInteractionUpdateRequest item, @MappingTarget AiInteraction aiInteraction);
}
