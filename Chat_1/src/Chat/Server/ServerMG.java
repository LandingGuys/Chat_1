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
			// System.out.println("服务器启动");
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
				//关闭服务器，同时关闭所有连接到服务器的Socket
				if(server!=null){
					server.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//在线用户操作
	ArrayList<ServerChat> alOnlineList=new ArrayList<>();
	public void addList(ServerChat sc){
		//限制重名
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
	//将新上线的用户发送给所有已在线的用户
	public void sendNewUsertoAll(ServerChat sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			ServerChat s=alOnlineList.get(i);
			s.sendMsg("ADD|"+sc.getName());
		}
		
	}
	//通过名字获取SeverChat
	public ServerChat getServerChatByName(String strName){
		for(int i=0;i<alOnlineList.size();i++){
			ServerChat serverChat = alOnlineList.get(i);
			if(serverChat.getName().equals(strName)){
				return serverChat;
			}
		}
		return null;
	}
	//群发信息(去掉自己）
	public void sendMsgToAll(String strMsg,ServerChat sc) {
		for(int i=0;i<alOnlineList.size();i++) {
			ServerChat serverChat = alOnlineList.get(i);
			if(!serverChat.equals(sc)) {
				serverChat.sendMsg(strMsg);
			}
			
		}
		
	}
	//发信息
	public void sendMsg(String strMsg,ServerChat sc){
		sc.sendMsg(strMsg);
	}
	
	
}
