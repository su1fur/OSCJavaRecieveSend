package launcher;

import osc.OSCReceiver;

public class Launcher {

    public static void main(String[] args) {
        OSCReceiver receiver;
        receiver = new OSCReceiver();
        receiver.Update();
    }

}
