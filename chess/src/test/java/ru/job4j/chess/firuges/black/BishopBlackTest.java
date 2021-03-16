package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import static org.hamcrest.core.Is.is;
import ru.job4j.chess.ImpossibleMoveException;


public class BishopBlackTest {

    @Test
    public void testPosition(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Assert.assertThat(Cell.C1, is(bishopBlack.position()));
    }

    @Test
    public void testCopy(){
        BishopBlack bishopBlack = new BishopBlack(Cell.G2);
        BishopBlack expected = new BishopBlack(Cell.H3);
        Assert.assertThat(expected, is (bishopBlack.copy(Cell.H3)));
    }

    @Test
    public void testWayC1toG5() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2,Cell.E3, Cell.F4, Cell.G5};
        Assert.assertThat(bishopBlack.way(Cell.G5), is(expected));
    }

    @Test
    public void testWayG5toC1() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] expected = {Cell.F4,Cell.E3, Cell.D2, Cell.C1};
        Assert.assertThat(bishopBlack.way(Cell.C1), is(expected));
    }

    @Test
    public void testWayE5toB8() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Cell[] expected = {Cell.D6,Cell.C7, Cell.B8};
        Assert.assertThat(bishopBlack.way(Cell.B8), is(expected));
    }

    @Test
    public void testWayB8toH2() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Cell[] expected = {Cell.C7,Cell.D6, Cell.E5, Cell.F4, Cell.G3, Cell.H2};
        Assert.assertThat(bishopBlack.way(Cell.H2), is(expected));
    }

    @Test
    public void diagonalOK(){
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Assert.assertTrue(bishopBlack.isDiagonal(Cell.E5));
    }

    @Test
    public void diagonalNG(){
        BishopBlack bishopBlack = new BishopBlack(Cell.E4);
        Assert.assertTrue(bishopBlack.isDiagonal(Cell.B1));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void testWayB8toH6ExeptionMove() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        bishopBlack.way(Cell.H6);
    }
}