
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.example.Util.parseCellCode;

public class CellCodeParserTest {

    @Test
    void testValidRegularPattern() {
        int[] result = parseCellCode("[A-1]");
        assertArrayEquals(new int[]{1, 1}, result);

        result = parseCellCode("[C-3]");
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    void testValidShortPattern() {
        int[] result = parseCellCode("a1");
        assertArrayEquals(new int[]{1, 1}, result);

        result = parseCellCode("d5");
        assertArrayEquals(new int[]{4, 5}, result);
    }

    @Test
    void testInvalidPatternThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("Z-1");  // 無効な行
        });
        assertEquals("Invalid cell code format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("a6");  // 無効な列
        });
        assertEquals("Invalid cell code format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("AA-1");  // フォーマットが異常
        });
        assertEquals("Invalid cell code format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("1A");  // 誤った順序
        });
        assertEquals("Invalid cell code format", exception.getMessage());
    }

    @Test
    void testEmptyOrNullThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("");  // 空文字
        });
        assertEquals("Invalid cell code format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode(null);  // null
        });
        assertEquals("Invalid cell code format", exception.getMessage());
    }

    @Test
    void testMalformedCellCodeThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("A-");  // 不完全なコード
        });
        assertEquals("Invalid cell code format", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCellCode("b");  // 不完全な短縮コード
        });
        assertEquals("Invalid cell code format", exception.getMessage());
    }
}
