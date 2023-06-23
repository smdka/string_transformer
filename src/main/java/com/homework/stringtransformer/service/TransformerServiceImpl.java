package com.homework.stringtransformer.service;

import com.homework.stringtransformer.dto.ElementDto;
import com.homework.stringtransformer.dto.ResponseDto;
import com.homework.stringtransformer.dto.TransformerDto;
import com.homework.stringtransformer.strategy.TransformationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class TransformerServiceImpl implements TransformerService {
    @Autowired
    private Map<String, TransformationStrategy> transformationStrategyMap;

    @Override
    public List<ResponseDto> transform(Collection<ElementDto> elementDtos) {
        List<ResponseDto> responseDtos = new ArrayList<>();

        for (ElementDto elementDto : elementDtos) {
            List<TransformerDto> transformerDtos = elementDto.getTransformerDtos();
            String value = elementDto.getValue();

            for (TransformerDto transformerDto : transformerDtos) {
                String transformerId = transformerDto.getTransformerId();
                List<String> parameters = transformerDto.getParameters();
                TransformationStrategy transformationStrategy = transformationStrategyMap.get(transformerId);

                if (transformationStrategy == null) {
                    throw new UnsupportedOperationException("Transformer type " + transformerId + " not supported");
                }

                String transformed = transformationStrategy.transform(value, parameters);
                responseDtos.add(new ResponseDto(value, transformed));
            }
        }
        return responseDtos;
    }
}
