package com.homework.stringtransformer.strategy;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("t3")
public class ReplaceCyrillicAndGreekWithLatinTransform implements TransformationStrategy {
    private final Map<Character, Character> toLatin = Map.of(
            '\u0391', '\u0041',
            '\u0392', '\u0042',
            '\u0395', '\u0045',
            '\u0410', '\u0041',
            '\u0412', '\u0042',
            '\u0415', '\u0045'
    );

    @Override
    public String transform(String source, List<String> params) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character replacement = toLatin.get(chars[i]);
            if (replacement != null) {
                chars[i] = replacement;
            }
        }
        return new String(chars);
    }
}
