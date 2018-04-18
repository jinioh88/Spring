package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2 implements InitializingBean, DisposableBean{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client.setHost() exe");
	}

	public void destroy() throws Exception {
		System.out.println("afterProp 실");
		
	}
	
	public void send() {
		System.out.println("Client.send() to "+host);
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("destroy() exe");
		
	}
	
	
}
