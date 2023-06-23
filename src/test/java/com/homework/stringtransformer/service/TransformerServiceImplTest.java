package com.homework.stringtransformer.service;

import com.homework.stringtransformer.dto.ElementDto;
import com.homework.stringtransformer.dto.ResponseDto;
import com.homework.stringtransformer.dto.TransformerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransformerServiceImplTest {
    public static final String SOME_RANDOM_TEXT = "Some random text";
    public static final String TRANSFORMER_ONE = "t1";
    public static final String TRANSFORMER_TWO = "t2";
    public static final String TRANSFORMER_THREE = "t3";
    public static final String GROUP = "group";
    private static final String TEXT_WITH_GREEK_AND_CYRILLIC = String.valueOf('\u0391' + '\u0412' + '\u0043');


    @Autowired
    TransformerServiceImpl transformerService;

    @Test
    void testReplaceByRegexTransformer() {
        String regex = "[o]+";
        String replacement = "a";
        List<TransformerDto> transformers = List.of(new TransformerDto(GROUP, TRANSFORMER_ONE, List.of(regex, replacement)));
        List<ResponseDto> response = transformerService.transform(List.of(new ElementDto(SOME_RANDOM_TEXT, transformers)));

        assertEquals(SOME_RANDOM_TEXT.replaceAll(regex, replacement), response.get(0).getTransformed());
    }

    @Test
    void testRemoveByRegexTransformer() {
        String regex = "[o]+";
        List<TransformerDto> transformers = List.of(new TransformerDto(GROUP, TRANSFORMER_TWO, List.of(regex)));
        List<ResponseDto> response = transformerService.transform(List.of(new ElementDto(SOME_RANDOM_TEXT, transformers)));

        assertEquals(SOME_RANDOM_TEXT.replaceAll(regex, ""), response.get(0).getTransformed());
    }

    @Test
    void testReplaceCyrillicAndGreekWithLatin() {
        List<TransformerDto> transformers = List.of(new TransformerDto(GROUP, TRANSFORMER_THREE, Collections.emptyList()));
        List<ResponseDto> response = transformerService.transform(List.of(new ElementDto(TEXT_WITH_GREEK_AND_CYRILLIC, transformers)));

        assertEquals(TEXT_WITH_GREEK_AND_CYRILLIC
                .replaceAll("\u0391", "\u0041")
                .replaceAll("\u0412", "\u0042"), response.get(0).getTransformed());
    }
}