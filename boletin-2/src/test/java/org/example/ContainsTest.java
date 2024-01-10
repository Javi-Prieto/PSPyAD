package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ContainsTest {




    @ParameterizedTest
    @MethodSource("generateCollectionWithEllements")
    <T> void testContains(Long[] items,Long value, boolean identity, boolean result){

        Contains<Long> contains = new Contains<>(items);
        assertEquals( result, contains.contains(value, identity));
    }

    public static Stream<Arguments> generateCollectionWithEllements() {
        return Stream.of(
                arguments(new Long[]{1L, 2L, 3L}, null, true, false),
                arguments(new Long[]{1L, 2L, 3L}, 1L, true, true),
                arguments(new Long[]{1L, 2L, 3L}, null, false, false),
                arguments(new Long[]{1L, 2L, 3L},1L, false, true)
        );
    }
}
