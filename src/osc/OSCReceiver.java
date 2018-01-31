package osc;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortIn;

import java.net.SocketException;

public class OSCReceiver {

    OSCPortIn receiver;
    OSCSender sender;
    public OSCReceiver(){

        try {
            receiver = new OSCPortIn(12345);
        } catch (SocketException e2) {
            e2.printStackTrace();
        }
        receiver.startListening();
    }

    public void Update(){

        OSCListener test = (time, message) -> {
            for(Object ob : message.getArguments()){
                Object ent = ob;
                System.out.println(ent);
                sender = new OSCSender("127.0.0.1", 12344);
                sender.send("test");

            }
        };
        receiver.addListener("/test",test);
    }
}
