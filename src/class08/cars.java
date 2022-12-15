package class08;

public abstract class cars {
    String fuelType;

    public cars(String fuelType) {
        this.fuelType = fuelType;
    }

    abstract void fuelType();
}

class toyota extends cars {
    public toyota(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Toyota drives using "+ fuelType);
    }
};

class Honda extends cars {
    public Honda(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Honda drives using "+ fuelType);
    }
};

class Tesla extends cars {
    public Tesla(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Tesla drives using "+fuelType);
    }
};
