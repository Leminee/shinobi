package shinobi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Player implements Serializable { 
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int id;
	private int numberOfFights = 0;
	private final byte lvl;
	private String email;
	private byte life = 120;
	private String grade = "Kage";
	private byte sennin = 0;
	private int stock = 1000000;
	private int chakra = 600;
	private String nickname;
	private byte pA = 20;
	private transient String password;
	private String gender;
	private List<Dress> playerDress = new ArrayList<>();
	private Dress dress;
	private Town town;

	public Player() { 
		lvl= 100;
		playerDress = new ArrayList<Dress>();
		id = count.incrementAndGet();

	}

	public String getPlayerData() {
		return "ID: " + getId() + "\n" + "Nickname: " + getNickname() + "\n" + "PA: " + getPA() + "\n" + "Sennin: "
				+ getSennin() + "/40" + "\n" + "Grade: " + getGrade() + "\n" + "life: " + getLife() + "/120" + "\n"
				+ "Niveau: " + getLvl() + " \n" + "Stock " + getStock() + " Ryos" + "\n" + "Chakra: " + getChakra()
				+ "/600" + "\n" + "Dorf: " + getTown();

	}

	public String getCurrentPlayerData() {
		return "    " + getNickname() + "\n" + "PA: " + getPA() + "\n" + "Sennin: " + getSennin() + "/40" + "\n"
				+ "life: " + getLife() + "/120" + " \n" + "Bourse " + getStock() + " Ryos" + "\n" + "Chakra: "
				+ getChakra() + "/600";

	}

	public String getPassword() {
		return password.toUpperCase();
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public byte getLvl() {
		return lvl;
	}

	public String getGrade() {
		return grade;
	}

	public byte getSennin() {
		if (sennin <= 40) {
			return sennin;
		} else {
			return 40;
		}

	}

	public int getStock() {
		return stock;
	}

	public int getChakra() {
		if (chakra > 0 && chakra <= 600) {
			return chakra;
		} else if (chakra <= 0) {
			return 0;
		} else {
			return 600;
		}
	}

	public String getNickname() {
		return nickname.toUpperCase();
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public byte getPA() {
		if (pA >= 0) {
			return pA;
		} else {
			return 0;
		}

	}

	public byte getLife() {
		if (life > 0 && life <= 120) {
			return life;
		} else if (life <= 0) {
			return 0;
		} else {
			return 120;
		}
	}

	public int getId() {
		return id;

	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public int attackMonster() {
		if (pA > 0 && life > 0) {
			return (stock = (int) (stock + 300 + Math.random() * 100))
					+ (life = (byte) ((life - 1) - Math.random() * 10)) + (pA--)
					+ (sennin = (byte) ((sennin + 3) + Math.random() * 5)) + (numberOfFights++);
		}
		return pA;

	}

	public int attackEnemy() {
		return (stock = (int) (stock + 500 + Math.random() * 100)) + (life = (byte) (life - 2))
				+ (chakra = (int) (chakra - 27 + Math.random() * 10)) + (pA--)
				+ (sennin = (byte) (sennin + 3 + Math.random() * 5)) + (numberOfFights++);
	}

	public String reg() {
		return "Life: " + (life = (byte) (life + 40)) + " Chakra: " + (chakra = chakra - 150);

	}

	public void resurrectPlayer() {
		if (getLife() == 0) {
			System.out.println((life = 120) + (chakra = chakra - 150));
		} else {
			System.err.println("Du bist tot!");
		}
	}

	public List<Dress> getPlayerDress() {
		return playerDress;
	}

	public void addDress(Dress dress) {
		this.playerDress.add(dress);

	}

	public int getNumberOfFights() {
		return numberOfFights;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

}
