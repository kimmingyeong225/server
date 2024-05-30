package project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

// 로그인
@Data
public class IndexPanel extends JPanel {

	// 백그라운드 이미지 컴포넌트
	private Image backgroundImage;
	private JPanel backgeroundPanel;

	// 보더 컴포넌트
	private JPanel borderPanel;

	// ip 컴포넌트
	private JPanel ipPanel;
	private JLabel ipLabel;
	private JTextField inputIp;

	// port 컴포넌트
	private JPanel portPanel;
	private JLabel portLabel;
	private JTextField inputPort;

	// id 컴포넌트
	private JPanel idPanel;
	private JLabel idLabel;
	private JTextField inputId;
	
	// 사진 선택

	// 로그인 버튼
	private JButton loginBtn;

	private ClientService clientService;

	public IndexPanel(ClientService clientService) {
		this.clientService = clientService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		// 백그라운드 이미지 컴포넌트
		backgroundImage = new ImageIcon("img/Yellow.png").getImage();
		backgeroundPanel = new JPanel();

		// 보더 컴포넌트
		borderPanel = new JPanel();

		// IP 컴포넌트
		ipPanel = new JPanel();
		ipLabel = new JLabel("HOST IP");
		inputIp = new JTextField(10);

		// RORT 컴포넌트
		portPanel = new JPanel();
		portLabel = new JLabel("PORT NUMBER");
		inputPort = new JTextField(10);

		// ID 컴포넌트
		idPanel = new JPanel();
		idLabel = new JLabel("ID");
		inputId = new JTextField(10);

		// 로그인 버튼
		loginBtn = new JButton("LOGIN");

	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		// 백그라운드 이미지 패널
		backgeroundPanel.setSize(getWidth(), getHeight());
		backgeroundPanel.setLayout(null);
		add(backgeroundPanel);

		// 보더 컴포넌트
		borderPanel.setBounds(100, 60, 190, 380);
		borderPanel.setLayout(null);
		borderPanel.setBackground(Color.WHITE);
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"LOGIN"));
		add(borderPanel);
		
		// IP 컴포넌트
		ipPanel.setBounds(30, 40, 120, 100);
		ipPanel.setBackground(new Color(0, 0, 0, 0));
		ipPanel.add(ipLabel);
		ipPanel.add(inputIp);
		borderPanel.add(ipPanel);

		// RORT 컴포넌트
		portPanel.setBounds(30, 140, 120, 100);
		portPanel.setBackground(new Color(0, 0, 0, 0));
		portPanel.add(portLabel);
		portPanel.add(inputPort);
		borderPanel.add(portPanel);

		// ID 컴포넌트
		idPanel.setBounds(30, 240, 120, 100);
		idPanel.setBackground(new Color(0, 0, 0, 0));
		idPanel.add(idLabel);
		idPanel.add(inputId);
		borderPanel.add(idPanel);

		// LoginBth 컴포넌트
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setBounds(30, 340, 120, 20);
		borderPanel.add(loginBtn);

		// 테스트 코드
		inputIp.setText("192.168.0.130");
		inputPort.setText("10000");

	}

	// Adapter -> 입력 받기
	
	private void initListener() {
		loginBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				clickLoginBtn();
			}

		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					clickLoginBtn();
				}
			}
		});
		
	}

	/* 각 입력칸이 null이 아닐때에 실행된다.  */
	private void clickLoginBtn() {
		if((!inputIp.getText().equals(null)) && (!inputPort.getText().equals(null)) 
				&& (!inputId.getText().equals(null))) {
			
			String ip = inputIp.getText();
			String stringPort = inputPort.getText();
			int port = Integer.parseInt(stringPort);
			String id = inputId.getText();
			
			clientService.clickConnectServerBhn(ip, port, id);
		}else {
			JOptionPane.showMessageDialog(null, "입력한 정보를 확인하세요", "알림" , JOptionPane.INFORMATION_MESSAGE);
			
		}

	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	}

}// end of class
