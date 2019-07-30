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
					//ServerMG.getServerMG().setLogTxt("����������" + str);
					String []commands=str.split("\\|");
					if(commands[0].equals("LOGIN")){//������¼����,��ʽ��LOGIN|UserName
						String sUser=commands[1];
						this.setName(sUser);
						 //1���õ����������û���Ϣ���ƣ����ظ��ͻ��ˣ�USERLISTS|user1_user2_user3
						ServerMG.getServerMG().getOnlineNames(this);
						//2������ǰ��¼�û�����Ϣ���û����������͸��Ѿ����ߵ������û���ADD|userName
						ServerMG.getServerMG().sendNewUsertoAll(this);
//				         3������ǰ��¼��Socket��Ϣ����Arraylist��
						ServerMG.getServerMG().addList(this);
						
					}else if(commands[0].equals("MSG")) {//MSG|SenderName|RecName|MSGInfo
						String SenderName=commands[1];
						String RecName=commands[2];
						String MSGinfo=commands[3];
						if(RecName.equals("All")) {
							//Ⱥ��
							//������ת��,��ʽ��MSG|SenderName|MSGinfo
							String strMsg="MSG|"+SenderName+"|"+MSGinfo;
							ServerMG.getServerMG().sendMsgToAll(strMsg,this);
							ServerMG.getServerMG().setLogTxt(SenderName+"������Ϣ����"+MSGinfo+"����"+RecName);
						}else {
							//����
							ServerChat sc=ServerMG.getServerMG().getServerChatByName(RecName);
							if(sc!=null){
								//������ת��,��ʽ��MSG|SenderName|MSGinfo
								String strMsg="MSG|"+SenderName+"|"+MSGinfo;
								ServerMG.getServerMG().sendMsg(strMsg, sc);
								ServerMG.getServerMG().setLogTxt(SenderName+"������Ϣ����"+MSGinfo+"����"+RecName);
							}
						}
						
					}
					else if (str.equals("end")) {
						// System.out.println("��ͷ��˶Ͽ�����");
					//	textLog.append("��ͷ��˶Ͽ�����");
						ServerMG.getServerMG().setLogTxt("��ͷ��˶Ͽ�����");
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
