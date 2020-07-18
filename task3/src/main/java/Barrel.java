public class Barrel {
    
    private Integer value;
    private Integer currentValue;

    public Barrel(Integer value, Integer currentValue) {
        this.value = value;
        this.currentValue = currentValue;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }
}
