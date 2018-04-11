package expert02;

import org.junit.Test;

import expert002.Car;
import expert002.KoreaTire;
import expert002.Tire;

public class CarTest {
	@Test
	public void koreaTireTest() {
		Tire tire1 = new KoreaTire();
		Car car1 = new Car(tire1);
	}
}
