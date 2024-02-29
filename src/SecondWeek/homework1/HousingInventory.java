package SecondWeek.homework1;

import SecondWeek.homework1.entity.House;
import SecondWeek.homework1.entity.SummerHouse;
import SecondWeek.homework1.entity.Villa;

import java.util.ArrayList;
import java.util.List;

public class HousingInventory {
    private final List<House> houseList = new ArrayList<>();
    private final List<Villa> villaList = new ArrayList<>();
    private final List<SummerHouse> summerHouseList = new ArrayList<>();

    public HousingInventory() {
    }

    public List<House> getHouseList() {
        return this.houseList;
    }

    public List<Villa> getVillaList() {
        return this.villaList;
    }

    public List<SummerHouse> getSummerHouseList() {
        return this.summerHouseList;
    }

    public void addHouse(House house) {
        this.houseList.add(house);
    }

    public void addVilla(Villa villa) {
        this.villaList.add(villa);
    }

    public void addSummerHouse(SummerHouse summerHouse) {
        this.summerHouseList.add(summerHouse);
    }

}
