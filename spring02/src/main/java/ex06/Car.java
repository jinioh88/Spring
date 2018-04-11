package ex06;

import javax.annotation.*;
public class Car {
	@Resource
	Tire tire;

	public String getTireBrand() {
		return "바퀴종류: " + tire.getBrand();
	}
}