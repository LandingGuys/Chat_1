package Chat.Server;

import java.io.*;
import java.net.*;


public class ServerLinster extends Thread{
	Socket scoket = null;
	ServerSocket server=null;
	 public ServerLinster(ServerSocket server) {
		 this.server=server;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				scoket = server.accept();
				// System.out.println("客服端信息" + scoket);
//				textLog.append("客服端信息" + scoket + "\r\n");
				ServerMG.getServerMG().setLogTxt("客服端信息" + scoket);
				new ServerChat(scoket).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	

}
