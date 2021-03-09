package ImbarcarePasageri;

/**
 * @author Stoian Miruna
 * Clasa Single este extinsa din clasa Pasager
 * Setez prioritatea pe 10 pentru fiecare familie
 *
 */
public class Single extends Pasager {

	Single(String id) {
		super(id);
		this.setPoints(0);
	}
}

