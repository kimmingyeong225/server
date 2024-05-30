package project4;

// 데이터를 가지고 오기 위한 인터페이스 (기능 인터페이스)

public interface ClientService {
	void clickConnectServerBhn(String ip, int port, String id);

	void clickMessageBhn(String messageText);

	void clickSecreMessageBhn(String msg);

	void clickMakeRoom(String roomName);

	void clickOutRoom(String roomName);

	void clickEnterRoom(String roomName);

}
