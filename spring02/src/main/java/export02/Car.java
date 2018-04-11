package export02;

public class Car {
	Tire tire;

	public Car(Tire tire1) {
		this.tire = tire1;
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	public String getTireBrand() {
		return "바퀴종류: " + tire.getBrand();
	}
}