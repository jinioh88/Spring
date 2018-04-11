package ex04;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	@Autowired
	Tire tire;

	public String getTireBrand() {
		return "바퀴종류: " + tire.getBrand();
	}
}