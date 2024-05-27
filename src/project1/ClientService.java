package project1;

// 데이터를 가지고 오기 위한 인터페이스 (기능 인터페이스)

public interface ClientService {
	void clickConnectServerBht(String ip, int port, String id);
	void clickMessageBht(String messageText);
	void clickSecreMessageBht(String msg);
	void clickMakeRoom(String roomName);
	void clickOutRoom(String roomName);
	void clickEnterRoom(String roomName);

}
