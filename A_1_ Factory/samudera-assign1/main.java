interface Model {
	String getModelName();
}

interface VehicleType {
	String getTypeName();
}

class SedanModel implements Model {
	@Override
	public String getModelName() {
		return "Sedan";
	}
}

class SportModel implements Model {
	@Override
	public String getModelName() {
		return "Sport";
	}
}

class FamilyType implements VehicleType {
	@Override
	public String getTypeName() {
		return "Family";
	}
}

class RacingType implements VehicleType {
	@Override
	public String getTypeName() {
		return "Racing";
	}
}

abstract class AbstractFactory {
	abstract Model createModel();

	abstract VehicleType createType();
}

class CarFactory extends AbstractFactory {
	@Override
	Model createModel() {
		return new SedanModel();
	}

	@Override
	VehicleType createType() {
		return new FamilyType();
	}
}

class MotorcycleFactory extends AbstractFactory {
	@Override
	Model createModel() {
		return new SportModel();
	}

	@Override
	VehicleType createType() {
		return new RacingType();
	}
}


class VehicleClient {
	private final Model model;
	private final VehicleType vehicleType;

	VehicleClient(AbstractFactory factory) {
		this.model = factory.createModel();
		this.vehicleType = factory.createType();
	}

	void displayInfo(String category) {
		System.out.println("Category : " + category);
		System.out.println("Model    : " + model.getModelName());
		System.out.println("Type     : " + vehicleType.getTypeName());
		System.out.println();
	}
}

class Main {
	public static void main(String[] args) {
		AbstractFactory carFactory = new CarFactory();
		VehicleClient car = new VehicleClient(carFactory);
		car.displayInfo("Car");

		AbstractFactory motorcycleFactory = new MotorcycleFactory();
		VehicleClient motorcycle = new VehicleClient(motorcycleFactory);
		motorcycle.displayInfo("Motorcycle");
	}
}

