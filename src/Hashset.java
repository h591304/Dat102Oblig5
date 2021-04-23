
import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class Hashset {

	public static int antElement = 1000000;
	public static final int FINNES_IKKE = -1;
	
	public static <T extends Comparable<T>> int binarySearch(T[] dataTab, int min, int max, T element) {
		
		if(min > max) {
			return FINNES_IKKE;
		}
		
		int mid = (min + max) / 2;
		int resultat = element.compareTo(dataTab[mid]);
		
		if(resultat == 0) {
			return resultat;
		}
		
		else if(resultat < 0) {
			resultat = binarySearch(dataTab, min, mid-1, element);
		}
		else {
			resultat = binarySearch(dataTab, mid+1, max, element);
		}
			return resultat;
	}
	
	public static void main(String[] args) {
		
		double tidStartHS, tidSluttHS, tidHS;
		double tidStartArr, tidSluttArr, tidArr;
		int tilfeldigTall;
		
		//Oppretter et hashset med 1000000 antall plasser
		HashSet<Integer> hashset = new HashSet<Integer>(antElement);
		//Oppretter et array med 1000000 antall plasser
		Integer bsTab[] = new Integer[antElement];
		
		int tall = 376;
		// Her kan vi bruke eit vilkårleg tal
		for (int i = 0; i < antElement; i++) {
			// legg tall til i HashSet og tabell 
			tall = (tall + 45713) % 1000000;
			// Sjå nedanfor om 45713
			hashset.add(tall);
			bsTab[i] = tall;
		}
		
		Arrays.sort(bsTab);
		Random tilfeldig = new Random();
		int antall = antElement - 1;
		
		//Måler tiden for hashset
		tidStartHS = System.nanoTime();
		for(int i = 0; i < bsTab.length; i++) {
			tilfeldigTall = tilfeldig.nextInt(antall);
			hashset.contains(tilfeldigTall);
		}
		tidSluttHS = System.nanoTime();
		tidHS = (tidSluttHS-tidStartHS) / Math.pow(10, 6);
		
		//Måler tiden for binærsøking på tabell
		tidStartArr = System.nanoTime();
		for(int i = 0; i < bsTab.length; i++) {
			tilfeldigTall = tilfeldig.nextInt(antall);
			binarySearch(bsTab, 0, bsTab.length-1, tilfeldigTall);
		}
		tidSluttArr = System.nanoTime();
		tidArr = (tidSluttArr-tidStartArr) / Math.pow(10, 6);
		
		System.out.println("Tiden for hashset å velge 10.000 antall elementer: " + tidHS + " millisekunder!");
		System.out.println("Tiden for binær søking å velge 10.000 antall elementer i en tabell: " + tidArr + " millisekunder!");
		
		
	}
	
}
