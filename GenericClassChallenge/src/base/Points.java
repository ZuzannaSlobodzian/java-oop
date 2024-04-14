package base;

import base.Mappable;

import java.util.Arrays;

public abstract class Points implements Mappable {

    private double[] location = new double[2];

    public Points(String location){
        this.location = Mappable.stringToLatLong(location);
    }

    private String location(){
        //System.out.println("Latitiude: "+(location[0]) + "; Longitiude: " + (location[1]));
        return  Arrays.toString(location);
    }

    @Override
    public void render() {
        System.out.println("Rendered " + this + "as POINT (" + location() + ")");
    }
}
