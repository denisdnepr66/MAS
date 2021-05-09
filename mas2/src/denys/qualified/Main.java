package denys.qualified;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(12,"asfdas", "asdfsdff", "aaa");
        Car car2 = new Car(13,"asfddfdas", "asdfsdfffdff", "asaaa");
        Car car3 = new Car(14,"ff", "asdfssddff", "affaa");

        Parking parking = new Parking("asfdff");
        parking.addCar(car1);
        parking.addCar(car2);
        car1.setParking(null);

        System.out.println(parking.getCars().size());
    }
}
