package strategyPattern;

public class StrategyGun implements Strategy {
    @Override
    public void runStrategy() {
        System.out.println("빵야 빵야 빵야!");
    }
}
