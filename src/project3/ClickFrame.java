package project3;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

// 이미지 선택하면 다른 창으로 넘어가는 프레임
// 수정 -> 이미지 말고 버튼 추가 해서 버튼 누르면 넘어가는 프레임

public class ClickFrame extends JFrame  {


	protected static final ClientService Client = null;

	ClickFrame mContext;

	private JLabel background;

	private JLabel chatting;
	private JLabel setting;
	private JLabel memo;
	private JLabel list;
	private JLabel weather;
	
	private JButton chattingBtn;
	private JButton settingBtn;
	private JButton menoBtn;
	private JButton listBtn;
	private JButton weatherBtn;

	public ClickFrame() {
		initData();
		setInitLayout();
//		addEventListener();
	}

	private void initData() {
		background = new JLabel(new ImageIcon("img/background.png"));
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(background);

		chatting = new JLabel(new ImageIcon("img/chatting2.png"));
		setting = new JLabel(new ImageIcon("img/setting2.png"));
		memo = new JLabel(new ImageIcon("img/memo2.png"));
		list = new JLabel(new ImageIcon("img/list2.png"));
		weather = new JLabel(new ImageIcon("img/weather2.png"));

		mContext = this;

	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(chatting);
		chatting.setSize(200, 180);
		chatting.setLocation(0, 520);

		add(setting);
		setting.setSize(200, 200);
		setting.setLocation(380, 520);

		add(memo);
		memo.setSize(200, 200);
		memo.setLocation(10, 150);

		add(list);
		list.setSize(200, 200);
		list.setLocation(190, 520);

		add(weather);
		weather.setSize(200, 200);
		weather.setLocation(380, 50);
		
		// 버튼
		chattingBtn = new JButton("⏩⏪채팅⏩⏪");
		chattingBtn.setBounds(190, 200, 200, 25);
		add(chattingBtn);
		
		settingBtn = new JButton("설정");
		settingBtn.setBounds(190, 300, 200, 25);
		add(settingBtn);
		
		menoBtn = new JButton("메모");
		menoBtn.setBounds(190, 300, 200, 25);
		add(menoBtn);
		
		listBtn = new JButton("To do List");
		listBtn.setBounds(190, 250, 200, 25);
		add(listBtn);
		
		weatherBtn = new JButton("날씨");
		weatherBtn.setBounds(190, 400, 200, 25);
//		add(weatherBtn);

	}

	
	
	private void addEventListener(ActionEvent e) {
	chattingBtn.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			new ClientFrame(Client).setVisible(true);
			
			dispose();
		}
	});	
		
		
	}

		
		
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ClickFrame().setVisible(true);
			}
		});
		
	}

}
