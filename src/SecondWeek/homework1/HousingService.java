package SecondWeek.homework1;

import SecondWeek.homework1.entity.House;
import SecondWeek.homework1.entity.SummerHouse;
import SecondWeek.homework1.entity.Villa;

public class HousingService {

    private final HousingInventory inventory;

    public HousingService(HousingInventory inventory) {
        this.inventory = inventory;
    }

    public void printHouses() {
        for (House house : inventory.getHouseList()) {
            System.out.println(house.toString());
        }
    }

    public void printVillas() {
        for (Villa villa : inventory.getVillaList()) {
            System.out.println(villa.toString());
        }
    }

    public void printSummerHouse() {
        for (SummerHouse summerHouse : inventory.getSummerHouseList()) {
            System.out.println(summerHouse.toString());
        }
    }
}
