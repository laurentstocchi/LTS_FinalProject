import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class main {
	
	static Random rand = new Random();
	static int firstPlateNumber, indiceLetter, secondPlateNumber, indiceSections, year, month, day, indiceType;
	static char firstLetter, secondLetter, thirdLetter, fourthLetter;
	static String theType, plate;
	static int formatPlate;
	static int compteurFR = 0;
	static int compteurLux = 0;
	static int compteurBel = 0;
	static int compteurAll = 0;
	static String theSection;
	static String [] carTypes = {"car","car","car","truck","motorcycle"};
	static String [] lesSections = {"A10","A11","A12","A13","A14","A15"};
	static char [] arrayLetter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	//on créé les sections en premier
	static Section sectionA10 = new Section("A10","Esch","Luxembourg",3);
	static Section sectionA11 = new Section("A11","Esch","Rodange",2);
	static Section sectionA12 = new Section("A12","Wiltz","Luxembourg",2);
	static Section sectionA13 = new Section("A13","Luxembourg","Metz",6);
	static Section sectionA14 = new Section("A14","Luxembourg","Trier",4);
	static Section sectionA15 = new Section("A15","Luxembourg","Arlon",5);
	

	public static Collection<Registration> registrations = new ArrayList<Registration>();
	private static HashMap<String,Car> vehicles = new HashMap<String,Car>();
	private static HashMap<String,String> passwordLogin = new HashMap<String,String>();
	
	private static <E, T> void process(Iterable<E> elements, Predicate<E> predicate, Function<E, T> mapper, Consumer<T> block) {
		for (E e : elements) {
			if (predicate.test(e)) {
				T value = mapper.apply(e);
				
				block.accept(value);
			}
		}
	}
	
	private static int getPrice(Car car){
		//il faut récupérer t pour ainsi faire section.getPrice
		return sectionA12.getPrice();
	}

	public static String getLuxPlate(){
		indiceLetter = rand.nextInt(arrayLetter.length);
		firstLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		secondLetter = arrayLetter[indiceLetter];
		firstPlateNumber = rand.nextInt(9929 - 1000 + 1) + 1000;
		return ""+firstLetter+secondLetter+" "+firstPlateNumber;
	}
	
	public static String getBelPlate(){
		firstPlateNumber = rand.nextInt(9 - 0 + 1) + 0;
		indiceLetter = rand.nextInt(arrayLetter.length);
		firstLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		secondLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		thirdLetter = arrayLetter[indiceLetter];
		secondPlateNumber = rand.nextInt(999 - 100 + 1) + 100;
		return ""+firstPlateNumber+"-"+firstLetter+secondLetter+thirdLetter+"-"+secondPlateNumber;
	}
	
	public static String getAllPlate(){
		indiceLetter = rand.nextInt(arrayLetter.length);
		firstLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		secondLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		thirdLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		fourthLetter = arrayLetter[indiceLetter];
		secondPlateNumber = rand.nextInt(9999 - 1000 + 1) + 1000;
		return ""+firstLetter+secondLetter+" "+thirdLetter+fourthLetter+" "+secondPlateNumber;
	}
	
	public static String getFrPlate(){
		indiceLetter = rand.nextInt(arrayLetter.length);
		firstLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		secondLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		thirdLetter = arrayLetter[indiceLetter];
		indiceLetter = rand.nextInt(arrayLetter.length);
		fourthLetter = arrayLetter[indiceLetter];
		secondPlateNumber = rand.nextInt(999 - 100 + 1) + 100;
		return ""+firstLetter+secondLetter+"-"+secondPlateNumber+"-"+thirdLetter+fourthLetter;
	}
	
	public static void main(String[] args) {
		java.util.Scanner entree =   new java.util.Scanner(System.in);
		passwordLogin.put("1234","lstocchi");
		passwordLogin.put("4321","imendoza");
		
		System.out.println("You must be logged for continue...");
		
		int index=0;
		int i = 0;
		int menuChoice = 0;
		
		do{
			
			System.out.println("Login :");
			String login = entree.next();
			System.out.println("Password :");
			String password = entree.next();
		
		Iterator iterator = passwordLogin.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
	 
			if(key.equals(password) && value.equals(login)){
				index=1;
				break;
			}
		}
		
		if(index==1){
			System.out.println("Welcome in the Luxembourg Toll System.");
		}else {
			System.out.println("Wrong password and/or login, please try again.");
		}
		
		}while(index==0);
		
		//Ici l'utilisateur est connecté
		try {
			System.out.println();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		for(i=0;i<10;i++){
			formatPlate = rand.nextInt(4 - 1 + 1)+ 1;
			switch(formatPlate){
			case 1 : 
				compteurLux++;
				plate=getLuxPlate();
				break;
			case 2 : 
				compteurBel++;
				plate=getBelPlate();
				break;
			case 3 :
				compteurAll++;
				plate=getAllPlate();
				break;
			case 4 : 
				compteurFR++;
				plate=getFrPlate();
				break;
			default : 
				compteurLux++;
				plate=getLuxPlate();
				break;
			}
			
			indiceSections = rand.nextInt(lesSections.length);
			theSection = lesSections[indiceSections];
			year = rand.nextInt(115 - 100 + 1) + 100;
			month = rand.nextInt(11 - 0 + 1) + 0;
			day = rand.nextInt(30 - 0 + 1) + 0;
			
			Registration car = new Registration(plate,theSection, new Date(year, month, day));
			
			indiceType = rand.nextInt(carTypes.length);
			theType = carTypes[indiceType];
			
			Car vehicle = new Car(plate,theType);
			
			if(vehicles.containsKey(plate)){
				System.out.println("Ce vehicule est déja inscrit dans le system, NO DUPLICATES ALLOW");
			}
			
			vehicles.put(plate,vehicle);
			
			registrations.add(car);
			
			System.out.println("--> Registration in section "+theSection+".");
			System.out.println("Plate number: "+plate+".");
			

			if(i%3==0){
				try {
					System.out.println();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(i%4==0){
				try {
					System.out.println();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		//le menu commence ici
		
		System.out.println();
		
		do{
			System.out.println();
			menuChoice = 0;
			
			System.out.println("----------------Luxembourg_Toll_System----------------");
			System.out.println();
			System.out.println("1. Afficher tout les enregistrements");
			System.out.println("2. Afficher les voitures circulant sur une section");
			System.out.println("3. Afficher la section utilisée par une voiture");
			System.out.println("4. Afficher les voitures circulant pour une date donnée");
			System.out.println("5. Afficher toutes les voitures");
			System.out.println("6. Facturer une voiture");
			System.out.println("7. Afficher les statistiques des nationalités des conducteurs");
			System.out.println("8. Continuer à observer les entrées dans le système");
			System.out.println("9. Afficher les informations d'une section");
			System.out.println("10. Afficher toutes les sections");
			System.out.println("11. Log out");
			System.out.println();
			System.out.println("----------------Luxembourg_Toll_System----------------");
			
			menuChoice = entree.nextInt();
			
			switch(menuChoice){
			case 1 : 
				process(registrations, e -> true, e -> e, e -> System.out.println(e));
				break;
			case 2 :
				System.out.println("Saisir le nom d'une section..");
				theSection = entree.next();
				process(registrations, e -> e.getSection().contains(theSection), e -> e.getPlate(), t -> System.out.println(t));
				break;
			case 3 : 
				System.out.println("Saisir la plaque de la voiture..");
				plate = entree.next();
				process(registrations, e -> e.getPlate().contains(plate), e -> e.getSection(), t -> System.out.println(t));
				break;
			case 4 : 
				System.out.println("Saisir une année..");
				year = entree.nextInt();
				System.out.println("Saisir un mois..");
				month = entree.nextInt();
				System.out.println("Saisir un jour..");
				day = entree.nextInt();
				process(registrations, e -> e.getDate().compareTo(new Date(year, month, day))==0, e -> e.getPlate(), t -> System.out.println(t));
				break;
			case 5 :
				System.out.println(vehicles.toString());
				break;
			case 6 : 
				System.out.println("Saisir la plaque de la voiture qu'il faut facturer..");
				plate = entree.next();
				int price = getPrice(vehicles.get(plate));
				System.out.println(price);
				break;
			case 7 :
				int compteurTotal=compteurFR+compteurLux+compteurBel+compteurAll;
				System.out.println("Fr : "+compteurFR+", soit "+(100*compteurFR)/compteurTotal+" %");
				System.out.println("Lux : "+compteurLux+", soit "+(100*compteurLux)/compteurTotal+" %");
				System.out.println("Bel : "+compteurBel+", soit "+(100*compteurBel)/compteurTotal+" %");
				System.out.println("All : "+compteurAll+", soit "+(100*compteurAll)/compteurTotal+" %");
				break;
			case 8 :
				for(i=0;i<30;i++){
					formatPlate = rand.nextInt(4 - 1 + 1)+ 1;
					switch(formatPlate){
					case 1 : 
						compteurLux++;
						plate=getLuxPlate();
						break;
					case 2 : 
						compteurBel++;
						plate=getBelPlate();
						break;
					case 3 :
						compteurAll++;
						plate=getAllPlate();
						break;
					case 4 : 
						compteurFR++;
						plate=getFrPlate();
						break;
					default : 
						compteurLux++;
						plate=getLuxPlate();
						break;
					}
					
					indiceSections = rand.nextInt(lesSections.length);
					theSection = lesSections[indiceSections];
					year = rand.nextInt(115 - 100 + 1) + 100;
					month = rand.nextInt(11 - 0 + 1) + 0;
					day = rand.nextInt(30 - 0 + 1) + 0;
					
					Registration car = new Registration(plate,theSection, new Date(year, month, day));
					
					indiceType = rand.nextInt(carTypes.length);
					theType = carTypes[indiceType];
					
					Car vehicle = new Car(plate,theType);
					
					if(vehicles.containsKey(plate)){
						System.out.println("Ce vehicule est déja inscrit dans le system, NO DUPLICATES ALLOW");
					}
					
					vehicles.put(plate,vehicle);
					
					registrations.add(car);
					
					System.out.println("--> Registration in section "+theSection+".");
					System.out.println("Plate number: "+plate+".");
					

					if(i%3==0){
						try {
							System.out.println();
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(i%4==0){
						try {
							System.out.println();
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				break;
			case 9 :
				System.out.println("Saisir une section..");
				theSection = entree.next();
				switch (theSection){
				case "A10" : 
					System.out.println(sectionA10.toString());
					break;
				case "A11" : 
					System.out.println(sectionA11.toString());
					break;
				case "A12" : 
					System.out.println(sectionA12.toString());
					break;
				case "A13" : 
					System.out.println(sectionA13.toString());
					break;
				case "A14" : 
					System.out.println(sectionA14.toString());
					break;
				case "A15" : 
					System.out.println(sectionA15.toString());
					break;
				default : 
					System.out.println("Cette section n'existe pas.");
				}
				break;
			case 10 :
				System.out.println(sectionA10.toString());
				System.out.println(sectionA11.toString());
				System.out.println(sectionA12.toString());
				System.out.println(sectionA13.toString());
				System.out.println(sectionA14.toString());
				System.out.println(sectionA15.toString());
				break;
			case 11 :
				System.out.println("Merci et à bientot.");
				break;
			default :
				System.out.println("Caractère non authorisé, please retry.");
				break;
			}
			
		}while(menuChoice!=11);
		
	}

}