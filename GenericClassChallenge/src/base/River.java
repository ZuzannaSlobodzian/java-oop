package base;

import base.Lines;

public class River extends Lines {
    private String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " base.River";
    }
}
