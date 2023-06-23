package com.homework.stringtransformer.controller;

import com.homework.stringtransformer.dto.ElementDto;
import com.homework.stringtransformer.dto.ResponseDto;
import com.homework.stringtransformer.service.TransformerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class StringTransformerController {
    @Autowired
    private TransformerService transformerService;

    @GetMapping("${transform.endpoint}")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseDto> transformStrings(@RequestBody List<@Valid ElementDto> elementDtos) {
        return transformerService.transform(elementDtos);
    }
}
