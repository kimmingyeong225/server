package project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;	

public class MainScreen extends JFrame {
	
	MainScreen m;
	
	    public MainScreen() {
	        setTitle("메인 화면");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // 로그인 버튼 생성
	        JButton loginButton = new JButton("로그인");
	        loginButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 로그인 버튼 클릭 시 다른 창으로 이동
	                openOtherWindow();
	            }
	        });

	        // 화면에 로그인 버튼 추가
	        add(loginButton, BorderLayout.CENTER);
	    }

	    private void openOtherWindow() {
	        // 다른 창으로 이동하는 코드 작성
	        // 예를 들어, 새로운 JFrame을 생성하거나 다른 화면으로 전환하는 로직을 추가하세요.
	        // 여기서는 간단히 메시지를 출력하는 방식으로 구현합니다.
	        JOptionPane.showMessageDialog(this, "다른 화면으로 이동합니다.");
//	        new WaitingRoomPanel(m);
	    }
	    

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            MainScreen mainScreen = new MainScreen();
	            mainScreen.setVisible(true);
	        });
	    }
	}



