package SecondWeek.homework1.entity;

public class SummerHouse extends Housing {
    public SummerHouse(Double price, int squareMeter, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "SummerHouse{" + super.toString() + "}";
    }
}