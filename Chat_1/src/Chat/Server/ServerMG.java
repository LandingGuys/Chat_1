package Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;


public class ServerMG {
	
	private static final ServerMG servermg=new ServerMG();
	
	private ServerMG(){}
	
	public static ServerMG getServerMG(){
		return servermg;
	}
	private ServerForm serverwin;
	public void setServerForm(ServerForm s){
		serverwin=s;
	}
	public void setLogTxt (String str){
		serverwin.textLog.append(str+"\r\n");
	}
	ServerSocket server = null;
	public boolean createServer(int port){
		try {
			server = new ServerSocket(port);//
			// System.out.println("����������");
			new ServerLinster(server).start();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void closeServer(){
			try {
				//�رշ�������ͬʱ�ر��������ӵ���������Socket
				if(server!=null){
					server.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//�����û�����
	ArrayList<ServerChat> alOnlineList=new ArrayList<>();
	public void addList(ServerChat sc){
		//��������
		alOnlineList.add(sc);
		
	}
	public void getOnlineNames(ServerChat sc){
		if(alOnlineList.size()>0){
			String sUsers="";
			for(int i=0;i<alOnlineList.size();i++){
				ServerChat s=alOnlineList.get(i);
				sUsers+=s.getName()+"_";
			}
			sc.sendMsg("USERLISTS|"+sUsers);
		}
	}
	//�������ߵ��û����͸����������ߵ��û�
	public void sendNewUsertoAll(ServerChat sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			ServerChat s=alOnlineList.get(i);
			s.sendMsg("ADD|"+sc.getName());
		}
		
	}
	//ͨ�����ֻ�ȡSeverChat
	public ServerChat getServerChatByName(String strName){
		for(int i=0;i<alOnlineList.size();i++){
			ServerChat serverChat = alOnlineList.get(i);
			if(serverChat.getName().equals(strName)){
				return serverChat;
			}
		}
		return null;
	}
	//Ⱥ����Ϣ(ȥ���Լ���
	public void sendMsgToAll(String strMsg,ServerChat sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			ServerChat serverChat = alOnlineList.get(i);
			if(!serverChat.equals(sc)) {
				serverChat.sendMsg(strMsg);
			}
			
		}
		
	}
	//����Ϣ
	public void sendMsg(String strMsg,ServerChat sc){
		sc.sendMsg(strMsg);
	}
	
	
}
