package com.homework.stringtransformer.service;

import com.homework.stringtransformer.dto.ElementDto;
import com.homework.stringtransformer.dto.ResponseDto;

import java.util.Collection;
import java.util.List;

public interface TransformerService {
    List<ResponseDto> transform(Collection<ElementDto> elementDtos);
}
