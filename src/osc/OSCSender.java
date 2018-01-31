package osc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortOut;

public class OSCSender {
	OSCPortOut sender;
	public OSCSender(String addressName, int port){
		sender =  null;
		try {
			sender = new OSCPortOut(InetAddress.getByName(addressName), port);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
	}

	public void send(String value){
		OSCMessage msg = new OSCMessage("/test/"+ value);
		try {
			sender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		sender.close();
	}
}
