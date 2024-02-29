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

    public Long getTotalPriceOfHouses() {
        long sum = 0;
        for (House house : inventory.getHouseList()) {
            sum += house.getPrice();
        }
        return sum;
    }

    public Long getTotalPriceOfVillas() {
        long sum = 0;
        for (Villa villa : inventory.getVillaList()) {
            sum += villa.getPrice();
        }
        return sum;
    }

    public Long getTotalPriceOfSummerHouses() {
        long sum = 0;
        for (SummerHouse summerHouse : inventory.getSummerHouseList()) {
            sum += summerHouse.getPrice();
        }
        return sum;
    }

    public Long getTotalPriceOfAllHousing() {
        return getTotalPriceOfHouses() + getTotalPriceOfVillas() + getTotalPriceOfSummerHouses();
    }
}
