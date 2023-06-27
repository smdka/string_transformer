package com.homework.stringtransformer.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("t1")
public class ReplaceByRegexTransform implements TransformationStrategy {
    @Override
    public String transform(String source, List<String> params) {
        log.info("Entering ReplaceByRegexTransform.transform: {}, {}", source, params);

        String response = source;
        for (int i = 0; i < params.size() - 1; i += 2) {
            response = response.replaceAll(params.get(i), params.get(i + 1));
        }

        log.info("Exiting ReplaceByRegexTransform.transform: {}", response);
        return response;
    }
}
