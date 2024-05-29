package project3;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

//import lombok.Data;

//@Data
public class ClientFrame extends JFrame {

	
	private JTabbedPane tapPane; // 탭
	private JPanel mainPanel;
	

//	// 로그인 창
//	private IndexPanel indexPanel;
//	
//	// 대기실 창
//	private WaitingRoomPanel waitingRoomPanel;
//	
//	// 채팅 창
//	private MessagePanel messagePanel;
//	
//	// 설정 창
//	private SettingPanel settingPanel;

	private ClientService clientservice; // 기능 인터페이스

	public ClientFrame(ClientService clientService) {
		this.clientservice = clientService;
		initObject();
		initSetting();
	}

	private void initObject() {
//		indexPanel = new IndexPanel(clientservice);
//		waitingRoomPanel = new WaitingRoomPanel(clientservice);
//		messagePanel = new MessagePanel(clientservice);
		//settingPanel = new SettingPanel(clientservice);

		tapPane = new JTabbedPane(JTabbedPane.TOP);
		mainPanel = new JPanel();

	}

	private void initSetting() {
		setTitle("[Talk]");
		setSize(400, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // () <- 여유 공간
		// EmptyBorder ->ClientFrame.Label처럼 평면 형태를 보여주는 보더
		mainPanel.setLayout(null);
		setContentPane(mainPanel);

		tapPane.setBounds(0, 0, getWidth(), getHeight());
//		mainPanel.add(tapPane);
		JLabel label = new JLabel("Welcome");
		add(label);
//		indexPanel.setLayout(null);
//		tapPane.addTab("로그인", null ,indexPanel, null);
//		tapPane.addTab("대기실", null, waitingRoomPanel, null);
//		tapPane.addTab("채팅", null, messagePanel, null);
//		//tapPane.addTab("설정", null, settingPanel, null);
		
		setVisible(true);

	}

}
