package proxyPattern;

public class ClientWithNoProxy {
    public static void main(String[] args) {
        IService service = new Proxy();
        System.out.println(service.runSomething());
    }
}
