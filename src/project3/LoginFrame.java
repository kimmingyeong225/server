package project3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import lombok.Data;

@Data
public class LoginFrame extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
//    private JTextField portField;
	private JButton loginButton;
	private JButton connectButton;

//    // 소켓 장치
//    private ServerSocket serverSocket;
//    private Socket socket;
//    
//    // 파일 저장을 위한 장치
//    private FileWriter fileWriter;
//    
//    // 서버 프레임 (테스트)
//    private ServerFrame serverFrame;

	public LoginFrame() {
		setTitle("Login");
		setSize(300, 250); // 300 , 150
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setBounds(10, 10, 80, 25);
		panel.add(usernameLabel);

		usernameField = new JTextField(20);
		usernameField.setBounds(100, 10, 160, 25);
		panel.add(usernameField);

		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordField = new JPasswordField(20);
		passwordField.setBounds(100, 40, 160, 25);
		panel.add(passwordField);

		loginButton = new JButton("Login");
		loginButton.setBounds(10, 150, 250, 25);
		panel.add(loginButton);

//        JLabel portLabel = new JLabel("PORT NUMBER :");
//        portLabel.setBounds(10, 70, 90, 25);
//        panel.add(portLabel);
//        
//        portField = new JPasswordField(20);
//        portField.setBounds(110, 70, 150, 25);
//        panel.add(portField);

		add(panel);
		
		// 테스트 코드 
		passwordField.setText("123"); 
		

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그인 버튼 클릭 시 처리
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
//                String portnumber = new String(portField.getText());

				// 서버에 로그인 요청을 보내고 응답을 처리
				// 로그인 성공 시 다음 화면으로 이동
				if (username.equals("민경") && password.equals("123")) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					// 다음 화면으로 이동
					new ClickFrame().setVisible(true);

					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "정보를 다시 확인해주세요");
				}
			}

		});
	}

//    public void startServer() {
//		try {
//			// 서버 소켓 장치
//			serverSocket = new ServerSocket(10000);
//			serverViewAppendWriter("[알림] 서버 시작\n");
//			serverFrame.getConnectBtn().setEnabled(false);
////			connectClient();
//
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다", "알림", JOptionPane.ERROR_MESSAGE);
//			serverFrame.getConnectBtn().setEnabled(true);
//		}
//	}
//
//    private void serverViewAppendWriter(String str) {
//    	try {
//			fileWriter = new FileWriter("talk_log.txt", true);
////			mainBoard.append(str);
//			fileWriter.write(str);
//			fileWriter.flush();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().setVisible(true);

			}
		});
	}
}
