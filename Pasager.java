package ImbarcarePasageri;

import java.util.ArrayList;

/**
 * @author Stoian Miruna
 *
 */
public  class Pasager {
	private ArrayList<Pasager> pasagerMembers;
	private int points;
	private int priority;
	private String id;

	/**
	 * @param id imi seteaza id-ul
	 */
	public Pasager(String id){
		
		setPasagerMembers(new ArrayList<>());
		setId(id);
	}

	
	/**
	 * Calculez prioritatea grupului de pasageri 
	 */
	public void calculatePriority() {
		
	    this.priority = 0;
		this.priority += this.points;
		for (Pasager pasager : getPasagerMembers()) {
			this.priority += pasager.getPoints();
		}
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {

	    this.points = points;
	}

	public int getPriority() {

		return priority;
	}

	public void setPriority(int priority) {

	    this.priority = priority;
	}

	public String getId() {

	    return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id
	 * In functie de id-ul primit adaug persoanele in grupul specific
	 * @return o persoana noua din grup
	 */
	public static Pasager createPasager(String id) {
		
		if(id.substring(0, 1).equals("f")) {
			return new Family(id);
		}
		else if(id.substring(0, 1).equals("g")) {
			return new Grup(id);
		}
		else {
			return new Single(id);
		}
	}

	public ArrayList<Pasager> getPasagerMembers() {
		return pasagerMembers;
	}

	public void setPasagerMembers(ArrayList<Pasager> PasagerMembers) {
		this.pasagerMembers = PasagerMembers;
	}

	/**
	 * //Adaug un nou membru in grupul specific
	 * @param pasager adauga un nou pasager
	 */
	public void addMember(Pasager pasager) {
		
		this.pasagerMembers.add(pasager);
		this.calculatePriority();
	}
}
