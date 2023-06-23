package com.homework.stringtransformer.strategy;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("t2")
public class RemoveByRegexTransform implements TransformationStrategy {
    @Override
    public String transform(String source, List<String> regexes) {
        String response = source;
        for (String regex : regexes) {
            response = response.replaceAll(regex, "");
        }
        return response;
    }
}
