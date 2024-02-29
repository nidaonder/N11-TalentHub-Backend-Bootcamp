package SecondWeek.homework1.entity;

public class Villa extends Housing {
    public Villa(Long price, int squareMeter, int numberOfRooms, int numberOfLivingRooms) {
        super(price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() + "}";
    }
}