package delhi.metro.system.beans;


/**
 * @author Shivam
 * This is pojo for Traveller
 *
 */
public class Traveller {

	private long id;
	private String name;

	public Traveller(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Traveller [id=" + id + ", name=" + name + "]";
	}

}
