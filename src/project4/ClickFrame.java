package project4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// 이미지 선택하면 다른 창으로 넘어가는 프레임
// 수정 -> 이미지 말고 버튼 추가 해서 버튼 누르면 넘어가는 프레임

public class ClickFrame extends JFrame  {

    private Client client; // ClientService 객체를 전달받기 위한 변수
    private Server server; // Server 객체를 전달받기 위한 변수

    ClickFrame mContext;
    
    private JLabel background;
    private JLabel chatting;
    private JLabel setting;
    private JLabel memo;
    private JLabel list;
    private JLabel weather;

    private JButton chattingBtn;
    private JButton settingBtn;
    private JButton memoBtn;
    private JButton listBtn;
    private JButton weatherBtn;

    public ClickFrame() {
        
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 중앙에 위치
		setResizable(false); // 프레임 조절 불가
		
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        background = new JLabel(new ImageIcon("img/background.png"));
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(background);
        
        // 이미지
        chatting = new JLabel(new ImageIcon("img/chatting2.png"));
		setting = new JLabel(new ImageIcon("img/setting2.png"));
		memo = new JLabel(new ImageIcon("img/memo2.png"));
		list = new JLabel(new ImageIcon("img/list2.png"));
		weather = new JLabel(new ImageIcon("img/weather2.png"));

		mContext = this;

		// 버튼
        chattingBtn = new JButton("⏩⏪채팅⏩⏪");
        chattingBtn.setBounds(190, 200, 200, 25);

        settingBtn = new JButton("서버관리자");
        settingBtn.setBounds(190, 250, 200, 25);

        memoBtn = new JButton("메모");
        memoBtn.setBounds(190, 300, 200, 25);

        listBtn = new JButton("리스트");
        listBtn.setBounds(190, 350, 200, 25);

        weatherBtn = new JButton("날씨");
        weatherBtn.setBounds(190, 400, 200, 25);
        
        server = new Server();
    }

    private void setInitLayout() {
        setLayout(null);
        add(chattingBtn);
        add(settingBtn);
        add(memoBtn);
//        add(listBtn);
//        add(weatherBtn);
        
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
    }

    private void addEventListener() {
        chattingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//client = new Client();
                new ClientFrame(client).setVisible(true);
            }
        });

        settingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new ServerFrame(server).setVisible(true);
               settingBtn.setEnabled(false);
            }
        });

        memoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MemoFrame().setVisible(true);
            }
        });

//        listBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                openNewFrame("리스트");
//            }
//        });
//
//        weatherBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                openNewFrame("날씨");
//            }
//        });
    }

//    private void openNewFrame(String title) {
//        JFrame newFrame = new JFrame(title);
//        newFrame.setSize(400, 300);
//        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        newFrame.setVisible(true);
//    }

    public static void main(String[] args) {
                new ClickFrame().setVisible(true);
            }
    
}
