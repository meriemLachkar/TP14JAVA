package ma.projet.bean;

public class Profile implements Identifiable {
	private static int counter = 0;
	private final int id = ++counter;
	private String code;
	private String description;

	// constructeurs, getters/setters, toString()...
	public Profile(String code, String description) {
		this.code = code;
		this.description = description;
	}

	@Override
	public int getId() {
		return id;

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", code=" + code + ", description=" + description + "]";
	}

}