
public enum Size {
    SMALL(5), MEDIUM(10), LARGE(20);

    public int basePrice;

    Size(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return Size;
    }
}
