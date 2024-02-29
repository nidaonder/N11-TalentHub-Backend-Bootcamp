package SecondWeek.homework1;

import SecondWeek.homework1.entity.House;
import SecondWeek.homework1.entity.SummerHouse;
import SecondWeek.homework1.entity.Villa;

public class Main {
    public static void main(String[] args) {

        HousingInventory inventory = new HousingInventory();

        House house1 = new House(300000D, 100, 2,1);
        House house2 = new House(400000D,120, 3,1 );
        House house3 = new House(500000D, 140, 3, 1);

        inventory.addHouse(house1);
        inventory.addHouse(house2);
        inventory.addHouse(house3);

        Villa villa1 = new Villa(700000D, 150, 3, 1);
        Villa villa2 = new Villa(900000D, 170, 4, 1);
        Villa villa3 = new Villa(1200000D, 210, 5,2);

        inventory.addVilla(villa1);
        inventory.addVilla(villa2);
        inventory.addVilla(villa3);

        SummerHouse summerHouse1 = new SummerHouse(2500000D, 210, 5,2);
        SummerHouse summerHouse2 = new SummerHouse(2700000D, 220, 5,2);
        SummerHouse summerHouse3 = new SummerHouse(2100000D, 190, 4,1);

        inventory.addSummerHouse(summerHouse1);
        inventory.addSummerHouse(summerHouse2);
        inventory.addSummerHouse(summerHouse3);

        HousingService service = new HousingService(inventory);

        service.printHouses();
        service.printVillas();
        service.printSummerHouse();
    }
}
