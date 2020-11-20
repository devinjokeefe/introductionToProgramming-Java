import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{

	public C4RandomAIPlayer(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	@Override
	public int selectColumn() {
		Random r = new Random();
		return r.nextInt(6);
	}

}
