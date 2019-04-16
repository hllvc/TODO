
public class Task {

	private String name;
	private boolean status;
	
	public Task(String name) {
		this.name = name;
		this.status = false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
