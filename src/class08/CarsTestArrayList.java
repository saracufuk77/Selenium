package class08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarsTestArrayList {
    public static void main(String[] args) {
        //using Arraylist to store objects
        List<cars> cars1 = new ArrayList<>();
        cars1.add(new toyota("Gasoline"));
        cars1.add(new Honda("Gasoline"));
        cars1.add(new Tesla("Electric"));

        System.out.println("--------Enhanced Loop-----");
        for (cars car : cars1) {
            car.fuelType();
        }

        System.out.println("-------For Loop-------");
        for (int i = 0; i < cars1.size(); i++) {
            cars1.get(i).fuelType();
        }

        System.out.println("---------Iterator-------");
        final var iterator = cars1.iterator();
        while (iterator.hasNext()){
            iterator.next().fuelType();
        }

    }
}
