package project4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import lombok.Data;

// 대기실
@Data
public class WaitingRoomPanel extends JPanel implements ActionListener {

	private Image backgroundImage;
	private JPanel backgroundJPanel;

	private JPanel userListJPanel;
	private JPanel roomListJPanel;
	private JPanel roomBtnPanel;
	private JPanel MessageJPanel;

	private JList<String> userList;
	private JList<String> roomList;

	private JTextField inputMsg;
	private JButton MsgBtn;

	private JButton makeRoomBtn;
	private JButton outRoomBtn;
	private JButton enterRoomBtn;

	private Vector<String> userIdVector = new Vector<>();
	private Vector<String> roomNameVector = new Vector<>();

	private ClientService clientService;

	public WaitingRoomPanel(ClientService clientService) {
		this.clientService = clientService;
		initObject();
		initSetting();
		initListener();
	}

	private void initObject() {
		backgroundImage = new ImageIcon("").getImage();
		backgroundJPanel = new JPanel();

		userListJPanel = new JPanel();
		roomListJPanel = new JPanel();
		roomBtnPanel = new JPanel();
		MessageJPanel = new JPanel();

		userList = new JList<>();
		roomList = new JList<>();

		inputMsg = new JTextField();
		MsgBtn = new JButton("SEND MESSAGE");
		makeRoomBtn = new JButton("ROOM 생성");
		outRoomBtn = new JButton("ROOM 나가기");
		enterRoomBtn = new JButton("ROOM 선택");

	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		userListJPanel.setBounds(50, 30, 120, 260);
		userListJPanel.setBackground(Color.white);
		userListJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "USER LIST"));

		userListJPanel.add(userList);
		add(userListJPanel);

		roomListJPanel.setBounds(230, 30, 120, 260);
		roomListJPanel.setBackground(Color.WHITE);
		roomListJPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "ROOM LIST"));
		roomListJPanel.add(roomList);
		add(roomListJPanel);

		roomBtnPanel.setBounds(50, 310, 300, 30);
		roomBtnPanel.setBackground(Color.WHITE);
		roomBtnPanel.setLayout(null);

		makeRoomBtn.setBounds(0, 5, 100, 25);
		makeRoomBtn.setBackground(Color.yellow);
		makeRoomBtn.setLayout(null);

		outRoomBtn.setBounds(108, 5, 85, 25);
		outRoomBtn.setBackground(Color.yellow);
		outRoomBtn.setLayout(null);

		enterRoomBtn.setBounds(200, 5, 100, 25);
		enterRoomBtn.setBackground(Color.yellow);
		enterRoomBtn.setLayout(null);

		roomBtnPanel.add(makeRoomBtn);
		roomBtnPanel.add(outRoomBtn);
		roomBtnPanel.add(enterRoomBtn);
		add(roomBtnPanel);

		inputMsg.setBounds(30, 5, 240, 23);
		MsgBtn.setBounds(30, 35, 240, 20);
		MsgBtn.setBackground(Color.WHITE);
		MsgBtn.setEnabled(false);

		MessageJPanel.setBounds(50, 360, 300, 60);
		MessageJPanel.setBackground(Color.yellow);
		MessageJPanel.setLayout(null);
		MessageJPanel.add(inputMsg);
		MessageJPanel.add(MsgBtn);
		add(MessageJPanel);

	}

	private void initListener() {
		makeRoomBtn.addActionListener(this);
		outRoomBtn.addActionListener(this);
		MsgBtn.addActionListener(this);
		enterRoomBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == MsgBtn) {
			String msg = inputMsg.getText();
			if (!msg.equals(null)) {
				clientService.clickMessageBhn(msg);
				inputMsg.setText("");
				userList.setSelectedValue(null, false);
			}
		} else if (e.getSource() == makeRoomBtn) {
			String roomName = JOptionPane.showInputDialog("[방 이름 설정]");

			if (!roomName.equals(null)) {
				clientService.clickMakeRoom(roomName);
			}
		} else if (e.getSource() == outRoomBtn) {
			String roomName = roomList.getSelectedValue();
			clientService.clickOutRoom(roomName);
			roomList.setSelectedValue(null, false);
		} else if (e.getSource() == enterRoomBtn) {
			String roomName = roomList.getSelectedValue();
			clientService.clickOutRoom(roomName);
			roomList.setSelectedValue(null, false);
		}

	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	}

}// end of class
