package base;

import base.Layer;

public class Main {
    public static void main(String[] args) {
         var nationalUSParks = new Park[]{
                 new Park("Yellowstone", "44.48, -110.59"),
                 new Park("Grand Canyon", "578.028, -1878.897"),
                 new Park("Yosemite", "67678.98, 536.97")
         };
         Layer<Park> parkLayer = new Layer<>(nationalUSParks);
         parkLayer.renderLayer();

         var majorUSRiver = new River[]{
                 new River("Missisipi", "364.9284, 654.974",
                         "8374.948, 4983.98", "847.86, 765.98"),
                 new River("Missouri", "7465.98, 762.23", "76.544, 865.98",
                         "83.88, 9837.86")
         };
         Layer<River> riverLayer = new Layer<>(majorUSRiver);
         riverLayer.addElements(new River("Colorado", "874.476, 476.98",
                 "847.98, 454.09"));
         riverLayer.renderLayer();
    }
}