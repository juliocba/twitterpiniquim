package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Twitter;
import modelo.TwitterDAO;

@ManagedBean
@SessionScoped
public class TwitterMB {

	private Twitter twitter;

	private List<Twitter> twitters;

	private Date data;

	private int id = 0;

	// private List<Integer> ids;

	private String login;

	public TwitterMB() {
		this.twitter = new Twitter();
	}

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Twitter> getTwitters() {
		if (twitters == null) {
			twitters = new ArrayList<Twitter>();
		}
		return twitters;
	}

	public void setTwitters(List<Twitter> twitters) {
		this.twitters = twitters;
	}

	public String salvar() {
		id++;
		String nomeAtual = twitter.getNome();
		data = new Date(System.currentTimeMillis());
		twitter.setData(data);
		twitter.setId(id);
		TwitterDAO.inserirTwitter(twitter);
		twitter = new Twitter();
		twitter.setNome(nomeAtual);
		listaTwitts();
		return "index";
	}

	public List<Twitter> listaTwitts() {
		return TwitterDAO.getTwitter();
	}

	public String remover() {
		TwitterDAO.removerTwitter();
		listaTwitts();
		return "index";
	}

}
