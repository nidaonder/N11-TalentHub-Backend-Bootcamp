package SecondWeek.homework1;

import SecondWeek.homework1.entity.House;
import SecondWeek.homework1.entity.SummerHouse;
import SecondWeek.homework1.entity.Villa;

public class Main {
    public static void main(String[] args) {

        HousingInventory inventory = new HousingInventory();

        House house1 = new House(300000L, 100, 2,1);
        House house2 = new House(400000L,120, 3,1 );
        House house3 = new House(500000L, 140, 3, 1);

        inventory.addHouse(house1);
        inventory.addHouse(house2);
        inventory.addHouse(house3);

        Villa villa1 = new Villa(700000L, 150, 3, 1);
        Villa villa2 = new Villa(900000L, 170, 4, 1);
        Villa villa3 = new Villa(1200000L, 210, 5,2);

        inventory.addVilla(villa1);
        inventory.addVilla(villa2);
        inventory.addVilla(villa3);

        SummerHouse summerHouse1 = new SummerHouse(2500000L, 210, 5,2);
        SummerHouse summerHouse2 = new SummerHouse(2700000L, 220, 5,2);
        SummerHouse summerHouse3 = new SummerHouse(2100000L, 190, 4,1);

        inventory.addSummerHouse(summerHouse1);
        inventory.addSummerHouse(summerHouse2);
        inventory.addSummerHouse(summerHouse3);

        HousingService service = new HousingService(inventory);

        service.printHouses();
        System.out.println();
        service.printVillas();
        System.out.println();
        service.printSummerHouse();

        System.out.println();

        System.out.println("Total price of houses = " + service.getTotalPriceOfHouses());
        System.out.println("Total price of villas = " + service.getTotalPriceOfVillas());
        System.out.println("Total price of summer houses = " + service.getTotalPriceOfSummerHouses());
        System.out.println("Total price of all housings = " + service.getTotalPriceOfAllHousing());

        System.out.println();

        System.out.println("Average square meter of houses = " + service.getAverageSquareMeterOfHouses());
        System.out.println("Average square meter of villas = " + service.getAverageSquareMeterOfVillas());
        System.out.println("Average square meter of summer houses = " + service.getAverageSquareMeterOfSummerHouses());
        System.out.println("Average square meter of housing = " + service.getAverageMeterOfHousing());

        System.out.println();

        System.out.println("filter = " + service.filterByRoomsAndLivingRooms(3,1));
    }
}
