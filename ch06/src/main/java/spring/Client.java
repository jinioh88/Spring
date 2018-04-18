package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client {
	private String host;
	
	public void setHost(String host) {
		this.host = host;
		System.out.println("Client2.setHost() exe");
	}
	
	public void connect() throws Exception{
		System.out.println("connect()");
	}
	 
	public void send() {
		System.out.println("Client.send() to "+host);
	}

	public void close() throws Exception{
		System.out.println("close()");
	}
	
	
}
