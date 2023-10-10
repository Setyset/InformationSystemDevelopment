package lab4.bicycle.model;

/**
 * Класс формы CreateForm
 */
public class CreateForm {
    private String brand;
    private String model;
    private String equipment;
    private int wheelDiameter;
    private int price;

    /**
     * Getter brand
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter brand
     *
     * @param brand brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter model
     *
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter model
     *
     * @param model model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Getter equipment
     *
     * @return equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * Setter equipment
     *
     * @param equipment equipment
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * Getter wheelDiameter
     *
     * @return wheelDiameter
     */
    public int getWheelDiameter() {
        return wheelDiameter;
    }

    /**
     * Setter wheelDiameter
     *
     * @param wheelDiameter wheelDiameter
     */
    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    /**
     * Getter price
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter price
     *
     * @param price price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
