package ImbarcarePasageri;
/**
 * @author Stoian Miruna
 * Clasa Family este extinsa din clasa Pasager
 * Setez prioritatea pe 10 pentru fiecare familie
 */
public class Family extends Pasager {
	
	Family(String id) {
		super(id);
		this.setPoints(10);
	}
}
