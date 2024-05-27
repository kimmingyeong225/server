package project1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ClientFrame extends JFrame {

	// 로그인 , 대기실 , 채팅
	private JTabbedPane tapPanel; // 탭
	private JPanel mainPanel;

	private IndexPanel indexPanel;
	private WaitingRoomPanel waitingRoomPanel;
	private MessagePanel messagePanel;
	
	private ClientService clientservice; // 기능 인터페이스 
	
	public ClientFrame(ClientService clientService) {
		this.clientservice = clientService;
		initObject();
		initSetting();
	}
	
	private void initObject() {
		indexPanel = new IndexPanel(clientservice);
		waitingRoomPanel = new WaitingRoomPanel(clientservice);
		messagePanel = new MessagePanel(clientservice);
		
		tapPanel = new JTabbedPane(JTabbedPane.LEFT);
		mainPanel = new JPanel();
				
		
	}

	private void initSetting() {
		setTitle("[Talk]");
		setSize(500,500);
		setLocation(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel.setBorder(new EmptyBorder(5,5,5,5)); // () <- 여유 공간
		// EmptyBorder ->ClientFrame.Label처럼 평면 형태를 보여주는 보더
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		
		tapPanel.setBounds(0,0, getWidth(),getHeight());
		mainPanel.add(tapPanel);
		
		
	
	}

	

}
