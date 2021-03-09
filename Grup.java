package ImbarcarePasageri;

/**
 * @author Stoian Miruna
 * Clasa Grup este extinsa din clasa Pasager
 *Setez prioritatea pe 10 pentru fiecare familie
 */
public class Grup extends Pasager {

	Grup(String id) {
		super(id);
		this.setPoints(0);
	}
}
