package lab4.entity;

public class Bicycle {
    private Long id;
    private String manufacturer;
    private String model;
    private String type;
    private Integer wheelSize;
    private Integer price;

    public Bicycle(Long id, String manufacturer, String model, String type, Integer wheelSize, Integer price){
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.wheelSize = wheelSize;
        this.price = price;
    }
    public Bicycle(String manufacturer, String model, String type, Integer wheelSize, Integer price){
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.wheelSize = wheelSize;
        this.price = price;
    }

    public Bicycle(){
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWheelSize(Integer wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Integer getWheelSize() {
        return wheelSize;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", wheelDiameter=" + wheelSize +
                ", price=" + price +
                '}';
    }
}
