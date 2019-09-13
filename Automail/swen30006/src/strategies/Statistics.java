package strategies;

public class Statistics {
	public static enum Type {COUNT, SUM, AVERAGE};
	
	private String name;
	private Type type;
	private int value;
	
	/**
	 * Constructor
	 * @param name name of statistics
	 * @param type type of this statistics 
	 */
	public Statistics(String name, Type type) {
		this.name = name;
		this.type = type;
		this.value = 0;
	}
	
	/**
	 * Increments the value of this instance
	 * @param value the amount to increment
	 */
	public void update(int value) {
		this.value += value;
	}
	
	public String toString() {
		return "This statistic records " + this.type + " of " + this.name + " with value of " + this.value + "\n";
	} 
	
	public String getName() {
		return this.name;
	}
}
