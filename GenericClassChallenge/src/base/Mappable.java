package base;

import java.util.Arrays;

public interface Mappable {
    void render();

    static double[] stringToLatLong(String location){
        var splits = location.split(",");
        double latitude = Double.parseDouble(splits[0]);
        double longitude = Double.parseDouble(splits[1]);

        return new double[]{latitude, longitude};
    }
}
