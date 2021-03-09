package ImbarcarePasageri;

//Clasa cu toate datele persoanelor
public class Crowd extends Pasager {
	 private String id;
	 private String name;
	 private int age;
	 private String ticketType;
	 private boolean priorityEmbark;
	 private boolean specialNeeds;
	 private int points = 0;
	//Setez datele persoanelor
	 
	/**
	 * @param id seteaza id-ul
	 * @param name	numele
	 * @param age	varsta pasagerului
	 * @param ticketType	tipul de bilet al pasagerului
	 * @param priorityEmbark	imbarcarea prioritara, daca exista
	 * @param specialNeeds	nevoi speciale, daca exista
	 * @throws Exception	in cazul in care varsta este negativa
	 */
	public Crowd(String id, String name, int age, String ticketType,
				   boolean priorityEmbark, boolean specialNeeds) throws Exception {
		super(id);
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setTicketType(ticketType);
		this.setPriorityEmbark(priorityEmbark);
		this.setSpecialNeeds(specialNeeds);
		this.calculatePoints();
	}

	/**
	 * In functie de varsta, tipul biletului ,
	 * sau nevoile speciale calculez prioritatea
	 */
	private void calculatePoints() {
		
		if (this.age >=0 && this.age < 2) {
			this.points += 20;
		}
		else if (this.age >= 2 && this.age < 5) {
			this.points += 10;
		}
		else if (this.age >= 5 && this.age < 10) {
			this.points += 5;
		}
		else if (this.age >= 60) {
			this.points += 15;
		}
		if(this.ticketType.equals("b")) {
			this.points += 35;
		}
		else if( this.ticketType.equals("p")) {
			this.points += 20;
		}
		if(this.priorityEmbark) {
			this.points += 30;
		}
		if(this.specialNeeds) {
			this.points += 100;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		if(age < 0) {
			throw new Exception("Age can not be negative");
		}
		this.age = age;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public boolean isPriorityEmbark() {
		return priorityEmbark;
	}

	public void setPriorityEmbark(boolean priorityEmbark) {
		this.priorityEmbark = priorityEmbark;
	}

	public boolean isSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(boolean specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}


