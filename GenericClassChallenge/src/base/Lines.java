package base;

import java.util.Arrays;

public abstract class Lines implements Mappable {

    private double[][] locations;

    //weird
    public Lines(String... latLong){
        this.locations = new double[latLong.length][];
        int index = 0;
        for(var l : latLong){
            this.locations[index++] = Mappable.stringToLatLong(l);
        }
    }

    private String locations(){
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Rendered " + this + "as LINE (" + locations() + ")");
        locations();
    }
}
