package unsw.dungeon;

public enum LayerEnum {
    PLAYER(0.0),
    ENEMYBOULDER(2.0),
    INVENTORY(2.5),
    BOTTOM(3.0),
    FLOOR(5.0);

    private final double z;

    private LayerEnum(double z) {
        this.z = z;
    }

    public double getZIndex() {
        return z;
    }
}

