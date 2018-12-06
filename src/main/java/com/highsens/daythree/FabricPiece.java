package com.highsens.daythree;

import java.util.Objects;

public class FabricPiece {
    private int x;
    private int y;

    public FabricPiece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FabricPiece)) return false;
        FabricPiece that = (FabricPiece) o;
        return x == that.x &&
                y == that.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
