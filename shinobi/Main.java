package shinobi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Town t[] = Town.values();
		 * 
		 * for (Town v : Town.values()) { System.out.println(v); }
		 */

		final long timeStart = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		/* Aktuelles Datum wird ausgegeben */
		Date.dateTime();

		System.out.println();

		Player firstPlayer = new Player();

		/*
		 * die in der Klasse Player implementierte Methode addDress fügt eine Beliebige
		 * Anzahl an Dress in die ArrayList ein
		 */

		// firstPlayer.addDress(new Dress("Bando", 200));

		System.out.println("        Spieler erstellen:");
		System.out.println();
		System.out.print(" - Schritt 1/5  Nickname: ");

		label1: while (true) {

			/*
			 * Ein Array wird mit Nicknames gefüllt und dessen Inhalt wird mit der Eingabe
			 * des Users verglichen, wenn die Eingabe gültig ist, also nicht in dem Array
			 * schon vorhanden ist und größer als 2 Buchstaben und kleiner als 10 ist, wird
			 * die Eingabe gesetzt und die Schleife verlassen, sonst muss erneut versucht
			 * werden
			 */

			String nickname = sc.nextLine();
			String[] playerNicknameList = { "Kami", "Mica", "Wayans", "Zak", "Uric", "Teckel", "hoow", "rabi", "owner",
					"qwerz", "bonda", "perry", "liyner", "scooby" };

			for (int i = 0; i < playerNicknameList.length; i++) {

				if (nickname.equalsIgnoreCase(playerNicknameList[i])) {
					System.err.println("Der Nickname existiert bereits!");
					continue label1;
				}
			}

			if (nickname.length() > 2 && nickname.length() < 11) {

				firstPlayer.setNickname(nickname);
				break;

			} else {
				System.err.println("Nickname zu kurz oder zu lang! ");

			}

		}

		System.out.print(" - Schritt 2/5  Passwort:  ");

		/*
		 * Hier wird nach einem gültigen Password gefragt, sollte das eingegebe Passwort
		 * kleiner 4 Ziffer sein, wird dies dem User angezeigt und es muss erneut
		 * versucht werden. In dem Fall, dass die Eingabe gültig ist, wird das Passwort
		 * gesetzt und die While-Schleife verlassen
		 */

		while (true) {

			String password = sc.nextLine();

			if (password.length() >= 8) {

				firstPlayer.setPassword(password);
				break;
			} else {
				System.err.println("Das eingegebene Passwort besteht aus nur " + password.length() + " Zeichen");
				System.err.println("Das Passwort muss mindenstens aus 8 Zeichen bestehen! ");

			}
		}

		System.out.print(" - Schritt 3/5 E-mail: ");

		while (true) {

			String email = sc.nextLine();

			if (EmailCheck.isValid(email)) {

				firstPlayer.setEmail(email);
				break;
			} else {
				System.err.println("Nicht erkannte E-Mail-Adresse");

			}
		}

		System.out.print(" - Schritt 4/5  Geschlecht:  M für Männlich oder W für Weiblich ");
		while (true) {
			String gender = sc.nextLine();
			if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("w")) {
				firstPlayer.setGender(gender);
				break;
			} else {
				System.err.println("Gib M für Männlich oder W für Weiblich");
			}

		}

		System.out.print(" - Schritt 5/5  Dorf: Chikara oder Mahou");

		while (true) {

			String town = sc.nextLine().toUpperCase();

			try {

				firstPlayer.setTown(Town.valueOf(town));
				break;

			} catch (IllegalArgumentException e) {

				System.err.println("falsche Eingabe! ");

			}
		}

		Thread.sleep(300);

		System.out.println("                              Dein Spieler wurde erfolgreich erstellt! ");
		System.out.println();

		System.out.println("Profil:  ");
		System.out.println();
		System.out.println(firstPlayer.getPlayerData());

		System.out.println("Gib 1 um einen Monster anzugreifen, 2 um einen Feind anzugreifen oder 3 für Regeneration ");

		while (true) {
			try {
				String input = sc.nextLine().toUpperCase();

				if (input.equals("EXIT")) {
					System.out.println("Ende");
					System.out.println("Anzahl Kämpfe : " + firstPlayer.getNumberOfFights());
					break;
				}
				int parseInput = Integer.parseInt(input);

				switch (parseInput) {

				case 1:
					firstPlayer.attackMonster();
					break;
				case 2:
					firstPlayer.attackEnemy();
					break;
				case 3:
					firstPlayer.reg();
					break;

				default:
					System.err.println(
							"1 -> Monster angreifen,  2 -> Feind angreifen, 3 -> Regemeration, Exit -> Exit  ");
				}
			} catch (NumberFormatException e) {
				System.err.println("Gib eine gültige Zahl ein");

			}

			System.out.println("++ " + firstPlayer.getSennin() + " Sennin , -- " + (20 - firstPlayer.getPA()) + " PA");
			System.out.println();

			if (firstPlayer.getPA() == 0 && firstPlayer.getLife() == 0) {
				System.out.println("Anzahl Kämpfe : " + firstPlayer.getNumberOfFights());
				System.out.println();
				System.err.println(" geworfenes Script");
				break;

			} else if (firstPlayer.getLife() == 0) {
				System.out.println("Anzahl Kämpfe : " + firstPlayer.getNumberOfFights());
				System.out.println();
				System.err.println("Du bist tot!");
				break;
			} else if (firstPlayer.getPA() == 0) {
				System.err.println("Du hast keine für die Aktion notwendigen PA! ");
				System.out.println();
				System.out.println("Anzahl Kämpfe : " + firstPlayer.getNumberOfFights());
				break;
			}

		}

		System.out.println();

		System.out.println(firstPlayer.getCurrentPlayerData());
		System.out.println();

		final long timeEnd = System.currentTimeMillis();
		long timeUsed = timeEnd - timeStart;

		if (timeUsed < 1000) {
			System.out.println("Verlaufszeit des Spieles: " + timeUsed + " ms.");
		} else {

			System.out.println("Verlaufszeit des Spieles: " + (timeUsed / 1000) + " sec.");
		}

		System.gc();

		Date.dateTime();

		try {

			FileOutputStream fos = new FileOutputStream("SavePlayerDataandActionsIntoAFile.sr"); 
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(firstPlayer);
				oos.close();
			

		} catch (IOException e) {
			System.err.println("Error");

		}
		
		

		
		 Player playerTwo = new Player();  
		 Player playerThree = new Player();
		 System.out.println(playerThree.getId());
		  
		 Player playerFour = new Player();  
		 System.out.println(playerFour.getId());
		 System.out.println(playerTwo.getId());
		 

		sc.close();

	}

}
