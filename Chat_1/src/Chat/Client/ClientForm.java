package Chat.Client;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;



import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class ClientForm extends JFrame {

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblNewLabel;
	public JTextField textIp;
	public JLabel label;
	public JTextField textPort;
	public JButton btnLogin;
	public JButton btnClose;
	
	
	ClientChat sthd=null;
	public JLabel label_4;
	public JTextField textUser;
	public JScrollPane scrollPane;
	public JTextArea textLog;
	public JScrollPane scrollPane_1;
	public JList listUser;
	public JPanel panel_1;
	public JScrollPane scrollPane_2;
	public JTextArea textSend;
	public JButton btnQunSend;
	public JButton btnSend;
	DefaultListModel<String> items;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientForm frame = new ClientForm();
					frame.setVisible(true);
					ClientMG.getClientMG().setClientForm(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u767B\u5F55\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 550, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("\u670D\u52A1\u5668IP:");
		lblNewLabel.setBounds(10, 25, 54, 15);
		panel.add(lblNewLabel);
		
		textIp = new JTextField();
		textIp.setText("192.168.0.108");
		textIp.setBounds(66, 22, 103, 21);
		panel.add(textIp);
		textIp.setColumns(10);
		
		label = new JLabel("\u7AEF\u53E3\uFF1A");
		label.setBounds(179, 25, 54, 15);
		panel.add(label);
		
		textPort = new JTextField();
		textPort.setText("65512");
		textPort.setBounds(210, 22, 66, 21);
		panel.add(textPort);
		textPort.setColumns(10);
		
		btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ButtonActionListener());
		btnLogin.setBounds(408, 21, 66, 23);
		panel.add(btnLogin);
		
		btnClose = new JButton("\u9000\u51FA");
		btnClose.addActionListener(new BtnCloseActionListener());
		btnClose.setBounds(474, 21, 66, 23);
		panel.add(btnClose);
		
		label_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_4.setBounds(286, 25, 54, 15);
		panel.add(label_4);
		
		textUser = new JTextField();
		textUser.setBounds(330, 22, 66, 21);
		panel.add(textUser);
		textUser.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new TitledBorder(null, "\u804A\u5929\u8BB0\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 104, 327, 264);
		contentPane.add(scrollPane);
		
		textLog = new JTextArea();
		textLog.setLineWrap(true);
		scrollPane.setViewportView(textLog);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBorder(new TitledBorder(null, "\u5728\u7EBF\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_1.setBounds(347, 104, 213, 263);
		contentPane.add(scrollPane_1);
		items=new DefaultListModel<String>();
		listUser = new JList(items);
		scrollPane_1.setViewportView(listUser);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 378, 550, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(10, 21, 520, 36);
		panel_1.add(scrollPane_2);
		
		textSend = new JTextArea();
		textSend.setLineWrap(true);
		scrollPane_2.setViewportView(textSend);
		
		btnQunSend = new JButton("\u7FA4\u53D1");
		btnQunSend.addActionListener(new BtnQunSendActionListener());
		btnQunSend.setBounds(389, 67, 74, 23);
		panel_1.add(btnQunSend);
		
		btnSend = new JButton("\u53D1\u9001");
		btnSend.addActionListener(new BtnSendActionListener());
		btnSend.setBounds(473, 67, 67, 23);
		panel_1.add(btnSend);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String IP=textIp.getText().trim();
			int port=Integer.parseInt(textPort.getText().trim());
			if(ClientMG.getClientMG().connection(IP, port, textUser.getText().trim())){
				ClientMG.getClientMG().setLogTxt("客户端已连接服务器");
			}else{
				ClientMG.getClientMG().setLogTxt("客户端连接服务器失败");
			}
		}
	}
	private class BtnCloseActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			sthd.sendMsg("end");
		}
	}
	private class BtnSendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//发送消息
//			 1、选择用户
//	          2、组织一个交互协议，发送到服务器：MSG|SenderName|RecName|MSGInfo
//		  		3、将发送消息显示在当前窗口的消息记录中
//	        	  4、接收服务器转发回的消息,显示在聊天记录中
			if(listUser.getSelectedIndex()>=0&&textSend.getText().trim()!=null) {
				String SenderName=ClientMG.getClientMG().getClientChat().getName();
				String RecName=listUser.getSelectedValue().toString();
				String MSGinfo=textSend.getText().trim();
				String strSend="MSG|"+SenderName+"|"+RecName+"|"+MSGinfo;
				ClientMG.getClientMG().getClientChat().sendMsg(strSend);
			//将自己发送的消息显示在聊天记录中
				ClientMG.getClientMG().setLogTxt("[我]：");
				ClientMG.getClientMG().setLogTxt(MSGinfo);
			//清空发送框
				textSend.setText("");
			}
			
		}
	}
	private class BtnQunSendActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(textSend.getText().trim()!=null) {
				String SenderName=ClientMG.getClientMG().getClientChat().getName();
				String RecName="All";
				String MSGinfo=textSend.getText().trim();
				String strSend="MSG|"+SenderName+"|"+RecName+"|"+MSGinfo;
				ClientMG.getClientMG().getClientChat().sendMsg(strSend);
			//将自己发送的消息显示在聊天记录中
				ClientMG.getClientMG().setLogTxt("[我]：");
				ClientMG.getClientMG().setLogTxt(MSGinfo);
			//清空发送框
				textSend.setText("");
			}
			
		}
	}
	
}