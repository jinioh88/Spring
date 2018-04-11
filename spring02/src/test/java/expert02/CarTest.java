package expert02;

import org.junit.Test;

import export02.Car;
import export02.KoreaTire;
import export02.Tire;

public class CarTest {
	@Test
	public void koreaTireTest() {
		Tire tire1 = new KoreaTire();
		Car car1 = new Car(tire1);
	}
}
