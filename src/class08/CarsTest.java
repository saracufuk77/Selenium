package class08;

import java.util.Arrays;
import java.util.Iterator;

public class CarsTest {
    public static void main(String[] args) {
        //regular ways of storing objects in an array
        cars[] carsArray = {new toyota("gasoline"),
                new Honda("Gasoline"),
                new Tesla("Electric")
        };

        System.out.println("---------Enhanced Loop----------");
        for (cars car : carsArray) {
            car.fuelType();
        }

        System.out.println("--------For Loop--------");
        for (int i = 0; i < carsArray.length; i++) {
            carsArray[i].fuelType();
        }

        System.out.println("---------Iterator-------");
        final var iterator = Arrays.stream(carsArray).iterator();
        while (iterator.hasNext()){
            iterator.next().fuelType();
        }
    }
}
