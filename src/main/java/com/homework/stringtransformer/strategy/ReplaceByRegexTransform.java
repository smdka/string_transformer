package com.homework.stringtransformer.strategy;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("t1")
public class ReplaceByRegexTransform implements TransformationStrategy {
    @Override
    public String transform(String source, List<String> params) {
        String response = source;
        for (int i = 0; i < params.size() - 1; i += 2) {
            response = response.replaceAll(params.get(i), params.get(i + 1));
        }
        return response;
    }
}
