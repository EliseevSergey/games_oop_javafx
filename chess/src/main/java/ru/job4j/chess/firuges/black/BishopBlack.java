package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(dest)) { throw new ImpossibleMoveException
                (String.format("Could not move by diagonal from %s to %s",position, dest));
        }
        int size = Math.abs(dest.getX() - this.position.getX());
        Cell[] steps = new Cell[size];
        int deltaX =  (dest.getX() - this.position.getX()) > 0 ? 1 : -1;
        int deltaY =  (dest.getY() - this.position.getY()) > 0 ? 1 : -1;
        int x = this.position.getX();
        int y = this.position.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
                steps[index] = Cell.findBy(x , y);
            }
        return steps;
        }

    public boolean isDiagonal(Cell dest) {
        return Math.abs(dest.getX() - position.getX()) == Math.abs(dest.getY() - position.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }
}
