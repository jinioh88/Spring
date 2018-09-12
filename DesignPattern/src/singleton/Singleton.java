package singleton;

public class Singleton {
    static Singleton singletonObject;

    private Singleton() {};

    public static Singleton getInstance() {
        if(singletonObject==null)
            singletonObject = new Singleton();
        return singletonObject;
    }

}
