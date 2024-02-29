package SecondWeek.homework1.entity;

public abstract class Housing {
    private Double price;
    private int squareMeter;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public Housing(Double price, int squareMeter) {
        this.price = price;
        this.squareMeter = squareMeter;
    }
}
