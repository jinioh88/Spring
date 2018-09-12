package templateCallback;


public class Soldier {
    void runContext(String weaponSound) {
        System.out.println("전투 시작");
        excuteWeapon(weaponSound).runStrategy();
        System.out.println("전투종료");
    }

    private Strategy excuteWeapon(final String weaponSound) {
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}
