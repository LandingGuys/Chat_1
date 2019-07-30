package Chat.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;



public class ServerChat extends Thread {
	BufferedReader br = null;
	PrintWriter pw = null;
	Socket scoket;

	public ServerChat(Socket scoket) {
		this.scoket = scoket;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(scoket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(scoket.getOutputStream(), "UTF-8")));
				String str ="";
				while((str=br.readLine())!=null){
					//ServerMG.getServerMG().setLogTxt("服务器接受" + str);
					String []commands=str.split("\\|");
					if(commands[0].equals("LOGIN")){//解析登录请求,格式：LOGIN|UserName
						String sUser=commands[1];
						this.setName(sUser);
						 //1、得到所有在线用户信息名称，发回给客户端：USERLISTS|user1_user2_user3
						ServerMG.getServerMG().getOnlineNames(this);
						//2、将当前登录用户的信息（用户名），发送给已经在线的其他用户：ADD|userName
						ServerMG.getServerMG().sendNewUsertoAll(this);
//				         3、将当前登录的Socket信息放入Arraylist中
						ServerMG.getServerMG().addList(this);
						
					}else if(commands[0].equals("MSG")) {//MSG|SenderName|RecName|MSGInfo
						String SenderName=commands[1];
						String RecName=commands[2];
						String MSGinfo=commands[3];
						if(RecName.equals("All")) {
							//群发
							//服务器转发,格式：MSG|SenderName|MSGinfo
							String strMsg="MSG|"+SenderName+"|"+MSGinfo;
							ServerMG.getServerMG().sendMsgToAll(strMsg,this);
							ServerMG.getServerMG().setLogTxt(SenderName+"发送消息：【"+MSGinfo+"】给"+RecName);
						}else {
							//单发
							ServerChat sc=ServerMG.getServerMG().getServerChatByName(RecName);
							if(sc!=null){
								//服务器转发,格式：MSG|SenderName|MSGinfo
								String strMsg="MSG|"+SenderName+"|"+MSGinfo;
								ServerMG.getServerMG().sendMsg(strMsg, sc);
								ServerMG.getServerMG().setLogTxt(SenderName+"发送消息：【"+MSGinfo+"】给"+RecName);
							}
						}
						
					}
					else if (str.equals("end")) {
						// System.out.println("与客服端断开连接");
					//	textLog.append("与客服端断开连接");
						ServerMG.getServerMG().setLogTxt("与客服端断开连接");
						break;
					}
				
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {

				if (scoket != null)
					scoket.close();
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	public void sendMsg(String str){
		pw.println(str);
		pw.flush();
	}

}
