package com.homework.stringtransformer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.List;

@Value
public class TransformerDto {
    @NotBlank
    String group;

    @NotBlank
    String transformerId;

    @NotNull
    List<String> parameters;
}
