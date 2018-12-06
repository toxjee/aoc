package com.highsens.daythree;

import java.util.Objects;

public class FabricPieceClaim {
    private int x;
    private int y;
    private int claimId;

    public FabricPieceClaim(int x, int y, int claimId) {
        this.x = x;
        this.y = y;
        this.claimId = claimId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FabricPieceClaim)) return false;
        FabricPieceClaim that = (FabricPieceClaim) o;
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

    public int getClaimId() {
        return claimId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
