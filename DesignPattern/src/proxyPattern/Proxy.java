package proxyPattern;

public class Proxy implements IService {

        IService service1;

        public String runSomething() {
            System.out.println("호출자에 대한 흐름 제어가 주목적");
            service1 = new Service();

            return service1.runSomething();
        }

}
