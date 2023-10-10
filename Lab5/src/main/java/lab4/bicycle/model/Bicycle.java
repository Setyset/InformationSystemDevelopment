package lab4.bicycle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Сущность Bicycles
 */
@Entity
@Table(name = "bicycles")
public class Bicycle {

    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String model;
    private String equipment;
    private int wheelDiameter;
    private int price;

    /**
     * Конструктор Bicycle
     */
    public Bicycle() {
    }

    /**
     * Конструктор Bicycle cо всеми полями, кроме Id
     *
     * @param brand         производитель
     * @param model         модель
     * @param wheelDiameter диаметр колес
     * @param price         цена
     * @param equipment     комплектация
     */
    public Bicycle(String brand, String model, String equipment, int wheelDiameter, int price) {
        this.brand = brand;
        this.model = model;
        this.equipment = equipment;
        this.wheelDiameter = wheelDiameter;
        this.price = price;
    }

    /**
     * Конструктор Bicycle c Id
     *
     * @param id            id
     * @param brand         производитель
     * @param model         модель
     * @param wheelDiameter диаметр колес
     * @param price         цена
     * @param equipment     комплектация
     */
    public Bicycle(long id, String brand, String model, String equipment, int wheelDiameter, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.equipment = equipment;
        this.wheelDiameter = wheelDiameter;
        this.price = price;
    }

    /**
     * Создание экземпляра из формы
     *
     * @param form CreateForm экземпляр
     * @return экземпляр Bicycle
     */
    public static Bicycle fromForm(CreateForm form) {
        Bicycle bicycle = new Bicycle(
                form.getBrand(),
                form.getModel(),
                form.getEquipment(),
                form.getWheelDiameter(),
                form.getPrice()
        );
        return bicycle;
    }

    /**
     * Создание экземпляра из формы
     *
     * @param form EditForm экземпляр
     * @return экземпляр Bicycle
     */
    public static Bicycle fromForm(EditForm form) {
        Bicycle bicycle = new Bicycle(
                form.getId(),
                form.getBrand(),
                form.getModel(),
                form.getEquipment(),
                form.getWheelDiameter(),
                form.getPrice()
        );
        return bicycle;
    }

    /**
     * Геттер id
     */
    public long getId() {
        return id;
    }

    /**
     * Сеттер id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Геттер brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Сеттер brand
     *
     * @param brand производитель
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Геттер model
     */
    public String getModel() {
        return model;
    }

    /**
     * Сеттер model
     *
     * @param model модель
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Геттер equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * Сеттер equipment
     *
     * @param equipment комплектация
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * Геттер wheelDiameter
     */
    public int getWheelDiameter() {
        return wheelDiameter;
    }

    /**
     * Сеттер wheelDiameter
     *
     * @param wheelDiameter диаметр колес
     */
    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    /**
     * Геттер price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Сеттер price
     *
     * @param price цена
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * ToString метод
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", equipment='" + equipment + '\'' +
                ", wheelDiameter=" + wheelDiameter +
                ", price=" + price +
                '}';
    }
}