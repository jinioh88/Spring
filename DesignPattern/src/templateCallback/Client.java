package templateCallback;

import strategyPattern.StrategyGun;
import strategyPattern.StrategySword;

public class Client {
    public static void main(String[] args) {
        Soldier rambo = new Soldier();

        rambo.runContext("빵야빵야빵야");
        System.out.println();

        rambo.runContext("챙챙챙챙!!");
    }
}
