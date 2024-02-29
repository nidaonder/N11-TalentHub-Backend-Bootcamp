package SecondWeek.homework1.entity;

public class House extends Housing {

    public House(Long price, int squareMeter, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "House{" + super.toString() + "}";
    }
}