package modelo;

import java.util.ArrayList;
import java.util.List;

public class TwitterDAO {

	public static List<Twitter> twitts = new ArrayList<Twitter>();

	static {
	}

	public static void inserirTwitter(Twitter twitter) {
		twitts.add(twitter);
	}

	public static List<Twitter> getTwitter() {
		return twitts;
	}

	public static void removerTwitter() {
		for (int i = 0; i < TwitterDAO.twitts.size(); i++) {
			if (TwitterDAO.twitts.get(i).getChecado() == true) {
				TwitterDAO.twitts.remove(i);
				i = 0;
			}
		}
	}

}
