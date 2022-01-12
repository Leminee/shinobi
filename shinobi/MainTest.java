package shinobi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTest {

	public static void main(String[] args) { 
	

		ArrayList<Dress> listOfClothes = new ArrayList<Dress>(3);

		String arrayy[] = { "Name", "Vorname", "Pseudo" }; 

		Arrays.sort(arrayy);

		for (String a : arrayy) {
			System.out.println(a);
		}

		ArrayList<String> str = new ArrayList<>();
		str.add("Name");
		str.add("Ame");
		str.add("Meane");
		str.add("Sena");
		Collections.sort(str);
		System.out.println(str.toString());

		for (String s : str) {
			System.out.println(s);
		}

		Dress firstDress = new Dress("Beta", 34);
		System.out.println(firstDress.hashCode());
		Dress dressTwo = new Dress("Beta", 34);
		System.out.println(dressTwo.hashCode());
		System.out.println(firstDress.hashCode());

		System.out.println();
		System.out.println(firstDress.toString()); 
	
		System.out.println(dressTwo.toString()); 
		 
	
	
		
		System.out.println(Dress.compareObject(firstDress, dressTwo));

		listOfClothes.add(new Dress("Capichon", 200));
		listOfClothes.add(new Dress("Pantalon", 150));
		listOfClothes.add(new Dress("Pantalo", 120)); 
		
		
		System.out.println(dressTwo.titel);
		// Collections.sort(listOfClothes); 
		
		Player onePlayer = new Player(); 
		onePlayer.setNickname("Souna"); 
		onePlayer.setGender("M");
		System.out.println(onePlayer.toString());  
		
		 Player playerTwo = new Player();  
		 Player playerThree = new Player();
		 System.out.println(playerThree.getId());
		  
		 Player playerFour = new Player();  
		 System.out.println(playerFour.getId());
		 System.out.println(playerTwo.getId());

	}

}