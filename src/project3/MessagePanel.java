package project3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

// 채팅
@Data
public class MessagePanel extends JPanel {

	// 백그라운드 이미지 컴포넌트
	private Image backgroundImage;
	private JPanel backgroundJPanel;

	// 패널
	private JPanel mainJPanel;
	private JPanel bottomPanel;

	// 스크롤
	private ScrollPane scrollPane;

	// 텍스트 컴포넌트
	private JTextArea mainMessageBox; // 여러 줄 입력
	private JTextField writeMessageBox;

	// 메세지 보내기 버튼
	private JButton MessageBtn;

	private ClientService clientService;

	public MessagePanel(ClientService clientService) {
		this.clientService = clientService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		backgroundImage = new ImageIcon("").getImage();
		backgroundJPanel = new JPanel();

		mainJPanel = new JPanel();
		bottomPanel = new JPanel();

		scrollPane = new ScrollPane();

		mainMessageBox = new JTextArea();
		writeMessageBox = new JTextField(17);
		MessageBtn = new JButton("전송");

	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		backgroundJPanel.setSize(getWidth(), getHeight());
		backgroundJPanel.setLayout(null);
		add(bottomPanel);

		mainMessageBox.setEnabled(false); // 버튼 비활성화
		mainJPanel.setBounds(40, 20, 300, 350);
		mainJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "채팅"));
		mainJPanel.setBackground(Color.yellow);
		mainJPanel.add(scrollPane);
		scrollPane.setBounds(45, 15, 280, 310);
		scrollPane.add(mainMessageBox);
		add(mainJPanel);

		MessageBtn.setBackground(Color.yellow);
		MessageBtn.setPreferredSize(new Dimension(60, 20));
		MessageBtn.setEnabled(false);
		bottomPanel.setBounds(43, 380, 294, 35);
		bottomPanel.setBackground(Color.white);
		bottomPanel.setBorder(new LineBorder(Color.BLACK, 2));
		bottomPanel.add(writeMessageBox);
		bottomPanel.add(MessageBtn);
		add(bottomPanel);

	}

	private void initListener() {
		MessageBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBtn();
			}

		});

		writeMessageBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					MessageBtn();
				}
			}

		});

	}

	private void MessageBtn() {
		if (!writeMessageBox.getText().equals(null)) {
			String msg = writeMessageBox.getText();
			clientService.clickMessageBhn(msg);
			writeMessageBox.setText("");
			writeMessageBox.requestFocus();
		}

	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	}

}// end of class
