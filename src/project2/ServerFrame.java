package project2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

@Data
public class ServerFrame extends JFrame {

	private Server mContext;
	private ScrollPane scrollPane;

	// 백그라운드 패널
	private BackgroundPanel backgroundPanel;

	// 메인 보드
	private JPanel mainPanel;
	private JTextArea mainBoard;

	// 포트패널
	private JPanel portJPanel;
	private JLabel portLabel;
	private JTextField inputPort;
	private JButton connectBtn;

	public ServerFrame(Server mContext) {
		this.mContext = mContext;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		// 백그라운드 패널
		backgroundPanel = new BackgroundPanel();

		// 메인 패널
		mainPanel = new JPanel();
		mainBoard = new JTextArea();

		scrollPane = new ScrollPane();

		// 포트패널
		portJPanel = new JPanel();
		portLabel = new JLabel("PORT NUMBER");
		inputPort = new JTextField(10);
		connectBtn = new JButton("CONNECT");

		// 테스트 코드
		inputPort.setText("10000");

	}

	private void initSetting() {
		setTitle("[Talk] - 서버관리자");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 포트패널 컴포넌트
		portJPanel.setBounds(50, 30, 300, 50);
		portJPanel.setBackground(new Color(0, 0, 0, 0));
		portJPanel.add(portLabel);
		portJPanel.add(inputPort);
		portJPanel.add(connectBtn);
		backgroundPanel.add(portJPanel);

		// 메인패널 컴포넌트
		mainPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "SERVER"));
		mainPanel.setBounds(40, 100, 320, 350);
		mainPanel.setBackground(Color.WHITE);

		mainBoard.setEnabled(false);
		mainPanel.add(scrollPane);
		scrollPane.setBounds(45, 100, 300, 315);
		scrollPane.add(mainBoard);
		backgroundPanel.add(mainPanel);

		setVisible(true);
	}

	private void initListener() {
		connectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mContext.startServer();
			}

		});

	}

	private class BackgroundPanel extends JPanel {
		private JPanel backgroundPanel;
		private Image backgroundImage;

		public BackgroundPanel() {
			backgroundImage = new ImageIcon("img/Yellow.png").getImage();
			backgroundPanel = new JPanel();
			add(backgroundPanel);
		}

		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		}

	}

}// end of class
