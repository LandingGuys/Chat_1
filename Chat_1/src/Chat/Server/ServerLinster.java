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
				// System.out.println("�ͷ�����Ϣ" + scoket);
//				textLog.append("�ͷ�����Ϣ" + scoket + "\r\n");
				ServerMG.getServerMG().setLogTxt("�ͷ�����Ϣ" + scoket);
				new ServerChat(scoket).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	

}
