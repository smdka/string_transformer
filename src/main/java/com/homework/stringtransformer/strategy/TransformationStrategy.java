package com.homework.stringtransformer.strategy;

import java.util.List;

public interface TransformationStrategy {
    String transform(String source, List<String> params);
}
