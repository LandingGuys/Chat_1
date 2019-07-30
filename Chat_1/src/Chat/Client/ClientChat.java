package Chat.Client;

import java.io.*;
import java.net.*;



public class ClientChat extends Thread{
	Socket socket=null;
	BufferedReader br=null;
	BufferedReader brkey=null;
	PrintWriter pw=null;
	public ClientChat(Socket socket,String user){
		super(user);
		this.socket=socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")));
			String sLOGIN="LOGIN|"+this.getName();
			sendMsg(sLOGIN);
			String str ="";
			while((str=br.readLine())!=null){
				String[]commands=str.split("\\|");
				if(commands[0].equals("USERLISTS")) {//USERLISTS|username 在线用户添加
					String [] sUsers=commands[1].split("\\_");
					ClientMG.getClientMG().addItems(sUsers);
					
				}else if(commands[0].equals("ADD")) {//ADD|username 一个在线用户添加
					String user=commands[1];
					ClientMG.getClientMG().addItem(user);
				}else if(commands[0].equals("MSG")) {//MSG|SenderName|MSGinfo
					String SenderName=commands[1];
					String MSGinfo=commands[2];
					
					ClientMG.getClientMG().setLogTxt("["+SenderName+"]：");
					ClientMG.getClientMG().setLogTxt(MSGinfo);
				}
				
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(socket!=null)
					socket.close();
				if(brkey!=null)
					brkey.close();
				if(pw!=null)
					pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	public void sendMsg(String str) {
		pw.println(str);
		pw.flush();
	}
	
	
	

}
