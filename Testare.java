package ImbarcarePasageri;

import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;

public class Testare {

	/**
	 * @author Stoian Miruna
	 * @param args argumentele functiei
	 * @throws Exception daca nu se poate deschide sau citi din fisier
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		int  nr_pasageri ;
		int checkList = 0;
		String st;
		//Creez fisierele din care citesc si in care scriu
		File filein = new File("./queue.in");
		File fileout = new File("./queue.out");

			BufferedReader br = new BufferedReader(new FileReader(filein));
		BufferedWriter out = new BufferedWriter(new FileWriter(fileout));
		//Creez un HashMap in care voi aduga membri
		MaxHeap maxHeap = new MaxHeap(200, out);
		HashMap<String, Pasager> groups = new HashMap<String, Pasager>();

		st = br.readLine();
		nr_pasageri = (st != null) ? Integer.parseInt(st) : 0;

		//Citesc gatele specifice fiecarui pasager
		for(int i = 0; i < nr_pasageri; i++) {
			st = br.readLine();
			String[] arrOfStr = st.split(" ", 6);
			String id = arrOfStr[0];
			String name = arrOfStr[1];
			int varsta = Integer.parseInt(arrOfStr[2]);
			String ticketTipe = (arrOfStr[3]);
			boolean  imbarcare_prioritara =Boolean.valueOf(arrOfStr[4]) ;
			boolean nevoi_speciale=Boolean.valueOf(arrOfStr[5]);

			//In functie de id verific daca grupul pasagerului
			//adaugat exista sau trebuie sa creez unul nou
			if(groups.containsKey(id)) {

				groups.get(id).addMember(new Crowd(id ,name,varsta,ticketTipe,imbarcare_prioritara,nevoi_speciale));
			}
			else {
				groups.put(id, Pasager.createPasager(id));
				groups.get(id).addMember(new Crowd(id ,name,varsta,ticketTipe,imbarcare_prioritara,nevoi_speciale));
			}
		}

		//In funnctie de stringul citit din fisier 
		//apelez functia specifica
		while ((st = br.readLine()) != null) {
			
			String[] array = st.split(" ");
			if(array[0].equals("insert")) {
				maxHeap.insert(groups.get(array[1]),0);

			}

			if(array[0].equals("embark")) {
				maxHeap.embark();
			}

			if(array[0].equals("list")) {
				
				maxHeap.list();

			}
		}
		//Inchid fisierele
		br.close();
		out.close();
	}
}
