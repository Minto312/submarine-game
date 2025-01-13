package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubmarineTest {

    private MapCell startCell;
    private MapCell targetCell;
    private Submarine submarine;
    private final int teamId = 1;

    @BeforeEach
    void setUp() {
        startCell = new MapCell(1, 1, false);
        targetCell = new MapCell(2, 2, false);
        submarine = new Submarine(startCell, 'A', teamId);
    }

    @Test
    void testConstructor() {
        assertEquals('A', submarine.getCode(), "コードが正しく設定されている");
        assertEquals(startCell, submarine.getCurrentCell(), "初期セルが正しい");
        assertTrue(startCell.existSubmarine(teamId), "セルに潜水艦が配置されている");
    }

    @Test
    void testMove() {
        submarine.move(targetCell);

        assertEquals(targetCell, submarine.getCurrentCell(), "移動後のセルが正しい");
        assertFalse(startCell.existSubmarine(teamId), "元のセルから潜水艦が削除されている");
        assertTrue(targetCell.existSubmarine(teamId), "新しいセルに潜水艦が配置されている");
    }

    @Test
    void testTakeDamage() {
        submarine.takeDamage();
        submarine.takeDamage();
        assertEquals(1, submarine.getHp(), "HPが正しく減少している");
        assertFalse(startCell.isBlocked(), "ダメージを受けてもHPが残っている場合はブロックされない");

        submarine.takeDamage();  // HPが0になる
        assertTrue(startCell.isBlocked(), "HPが0になった場合、セルがブロック状態になる");
    }

    @Test
    void testCannotMoveToBlockedCell() {
        targetCell.sinkSubmarine();  // セルをブロック状態にする
        assertThrows(IllegalArgumentException.class, () -> {
            submarine.move(targetCell);
        }, "ブロックされたセルに移動しようとすると例外がスローされるべき");
    }

    @Test
    void testCannotPlaceTwoSubmarinesInSameCell() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Submarine submarineA = new Submarine(startCell, 'A', teamId);
            Submarine submarineB = new Submarine(startCell, 'B', teamId);
        }, "同じセルに2つの潜水艦を配置すると例外がスローされるべき");
        assertEquals("Submarine already exists", exception.getMessage(), "例外メッセージが正しい");
    }
}
