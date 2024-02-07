package seminars.second.hw;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Yamaha", "V-max", 2000);
    }
    /**
     * 2.1 Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
     */
    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * 2.2 Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarIsGetNumWheels() {
        assertTrue(car.getNumWheels() == 4);
    }

    /**
     * 2.3 Проверить, что объект Motorcycle создается с 2-мя колесами.*
     */
    @Test
    public void testMotorcycleIsGetNumWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * 2.4 Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testCarTestDrive() {
        car.testDrive();

        assertTrue(car.getSpeed() == 60);
    }

    /**
     * 2.5 Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testMotorcycleTestDrive() {
        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }
    /**
     * 2.6 Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */
    @Test
    public void testCarPark() {
        car.testDrive();
        car.park();

        assertTrue(car.getSpeed() == 0);
    }


    /**
     *  2.7 Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */
    @ParameterizedTest
    @ValueSource(ints = 0)
    public void testMotorcyclePark(int speed) {
        motorcycle.testDrive();
        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(speed);
    }
}
