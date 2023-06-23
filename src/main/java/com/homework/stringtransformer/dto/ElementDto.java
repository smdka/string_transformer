package com.homework.stringtransformer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class ElementDto {
    @NotBlank
    String value;

    @NotNull
    List<@Valid TransformerDto> transformerDtos;
}
