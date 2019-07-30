package Chat.Client;

import java.awt.Component;
import java.io.IOException;
import java.net.Socket;


public class ClientMG {
	
	private static final ClientMG clientmg=new ClientMG();
	
	private ClientMG(){}
	
	public static ClientMG getClientMG(){
		return clientmg;
	}
	private ClientForm clientwin;
	public void setClientForm(ClientForm s){
		clientwin=s;
	}
	public void setLogTxt (String str){
		clientwin.textLog.append(str+"\r\n");;
	}
	
	public String getTextSend() {
		return clientwin.textSend.getText();
	}
	ClientChat sthd;
	
	public ClientChat getClientChat(){
		return sthd;
	}
	public boolean connection(String IP,int port,String tUser){
		Socket socket=null;
		try {
			socket = new Socket(IP, port);
			//System.out.println("ï¿½ï¿½ï¿½Óµï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½");
			//textResult.setText("ï¿½ï¿½ï¿½Óµï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½");
			sthd=new ClientChat(socket,tUser);
			sthd.start();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//ÔÚÏßÓÃ»§ÃûÊý¼¶Ìí¼Óµ½ListÖÐ
	public void addItems(String []users) {
		for(int i=0;i<users.length;i++) {
			clientwin.items.addElement(users[i]);
		}
	}
	//Ìí¼ÓÒ»¸öÓÃ»§µ½List
	public void addItem(String user) {
		clientwin.items.addElement(user);
	}
	//
	
	
}
