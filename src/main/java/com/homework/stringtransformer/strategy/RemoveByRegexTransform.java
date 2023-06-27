package com.homework.stringtransformer.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("t2")
public class RemoveByRegexTransform implements TransformationStrategy {
    @Override
    public String transform(String source, List<String> regexes) {
        log.info("Entering RemoveByRegexTransform.transform: {}, {}", source, regexes);

        String response = source;
        for (String regex : regexes) {
            response = response.replaceAll(regex, "");
        }

        log.info("Exiting RemoveByRegexTransform.transform: {}", response);
        return response;
    }
}
