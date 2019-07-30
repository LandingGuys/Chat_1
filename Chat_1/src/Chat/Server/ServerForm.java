package Chat.Server;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;



import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.*;

import java.net.*;
import java.awt.event.ActionEvent;

public class ServerForm extends JFrame {

	private JPanel contentPane;
	public JLabel label;
	public JTextField textPort;
	public JButton btnStart;
	public JButton btnEnd;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JTextArea textLog;
	ServerSocket server = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
					ServerMG.getServerMG().setServerForm(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u914D\u7F6E\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 365, 68);
		contentPane.add(panel);
		panel.setLayout(null);

		label = new JLabel("\u7AEF\u53E3\uFF1A");
		label.setBounds(10, 24, 54, 15);
		panel.add(label);

		textPort = new JTextField();
		textPort.setText("65512");
		textPort.setBounds(46, 21, 66, 21);
		panel.add(textPort);
		textPort.setColumns(10);

		btnEnd = new JButton("\u5173\u95ED\u670D\u52A1");
		btnEnd.addActionListener(new BtnEndActionListener());
		btnEnd.setBounds(262, 21, 93, 23);
		panel.add(btnEnd);

		btnStart = new JButton("\u5F00\u542F\u670D\u52A1");
		btnStart.addActionListener(new ButtonActionListener());
		btnStart.setBounds(150, 21, 93, 23);
		panel.add(btnStart);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 88, 365, 254);
		contentPane.add(scrollPane);

		textLog = new JTextArea();
		textLog.setLineWrap(true);
		textLog.setBorder(
				new TitledBorder(null, "\u6D88\u606F\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(textLog);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int port = Integer.parseInt(textPort.getText().trim());
			if(ServerMG.getServerMG().createServer(port)){
				ServerMG.getServerMG().setLogTxt("服务器启动...");
			}else{
				ServerMG.getServerMG().setLogTxt("服务器启动失败！");
			}

		}
	}
	private class BtnEndActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			ServerMG.getServerMG().closeServer();
		}
	}

//	class ServerThd extends Thread {
//		Socket scoket = null;
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			while (true) {
//				try {
//					scoket = server.accept();
//					// System.out.println("客服端信息" + scoket);
//					textLog.append("客服端信息" + scoket + "\r\n");
//
//					new SocketThread(scoket).start();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		}
//	}

//	class SocketThread extends Thread {
//		BufferedReader br = null;
//		PrintWriter pw = null;
//		Socket scoket;
//
//		public SocketThread(Socket scoket) {
//			this.scoket = scoket;
//		}
//
//		@Override
//		public void run() {
//			try {
//				br = new BufferedReader(new InputStreamReader(scoket.getInputStream(), "UTF-8"));
//				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(scoket.getOutputStream(), "UTF-8")));
//				while (true) {
//					String str = br.readLine();
//					// System.out.println("服务器接受" + str);
//					textLog.append("服务器接受" + str + "\r\n");
//					if ("end".equals(str)) {
//						// System.out.println("与客服端断开连接");
//						textLog.append("与客服端断开连接");
//						break;
//					}
//					String[] splits = str.split("\\|");
//					double mate1 = Double.parseDouble(splits[0]);
//					double mate2 = Double.parseDouble(splits[1]);
//					String commands = splits[2];
//					double result=0;
//					
//					if (commands.equals("+")) {
//						// 加法
//						result=mate1+mate2;
//						pw.println(result);
//						pw.flush();
//					
//					} else if (commands.equals("-")) {
//						// 减法
//						result=mate1-mate2;
//						pw.println(result);
//						pw.flush();
//					} else if (commands.equals("*")) {
//						// 减法
//						result=mate1*mate2;
//						pw.println(result);
//						pw.flush();
//					} else if (commands.equals("/")) {
//						// 减法
//						if(mate2!=0){
//							result=mate1/mate2;
//							pw.println(result);
//							pw.flush();
//						}else{
//							pw.println("除数不能为0");
//							pw.flush();
//						}
//						
//					}
//
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			} finally {
//				try {
//
//					if (scoket != null)
//						scoket.close();
//					if (br != null)
//						br.close();
//					if (pw != null)
//						pw.close();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//
//		}
//	}

}
