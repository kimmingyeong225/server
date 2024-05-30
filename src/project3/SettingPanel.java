package project3;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import lombok.Data;

// 설정
// 프로필(사진, 이름)
// 테마(채팅 화면 바꿀 수 있는..)
// 이모티콘
// 글꼴
@Data
public class SettingPanel extends JPanel implements ActionListener{

	// 백그라운드 이미지 컴포넌트
	private Image backgroundImage;
	private JPanel backgroundJPanel;
	
	private JPanel profileJPanel;
	
	// 
	
	
	public SettingPanel(ClientService clientService) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
