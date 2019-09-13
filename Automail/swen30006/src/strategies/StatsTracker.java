package strategies;

import java.util.ArrayList;

public class StatsTracker {
	public static final String NORMAL_TOTAL = "Number of packages delivered normally";
	public static final String OVERDRIVE_TOTAL = "Number of packages delivered using overdrive";
	public static final String NORMAL_WEIGHT = "Total weight of packages delivered normally";
	public static final String OVERDRIVE_WEIGHT = "Total weight of packages delivered using overdrive";
	
	private static StatsTracker trackerInstance = null;
	private ArrayList<Statistics> statistics = new ArrayList<Statistics>();
	
	
	//Singleton class constructor
	private StatsTracker() {
		statistics.add(new Statistics(NORMAL_TOTAL, Statistics.Type.COUNT));
		statistics.add(new Statistics(OVERDRIVE_TOTAL, Statistics.Type.COUNT));
		statistics.add(new Statistics(NORMAL_WEIGHT, Statistics.Type.SUM));
		statistics.add(new Statistics(OVERDRIVE_WEIGHT, Statistics.Type.SUM));
	}
	
	/**
	 * Singleton
	 * @return the singleton instance of StatsTracker
	 */
	public static StatsTracker getInstance() {
		if (trackerInstance == null) {
			trackerInstance = new StatsTracker();
		}
		return trackerInstance;
	}
	
	/**
	 * updates the individual statistics for each appropriate field
	 * @param isOverdrive true if the package was delivered using overdrive
	 * @param weight int weight of said package
	 */
	public void updateStats(boolean isOverdrive, int weight) {
		for (Statistics i: statistics) {
			if (isOverdrive) {
				//Increments counter for packages delivered with overdrive by 1
				if (i.getName().contentEquals(OVERDRIVE_TOTAL)) {
					i.update(1);
				} 
				//Increments sum of package weights delivered with overdrive by its weight
				else if (i.getName().contentEquals(OVERDRIVE_WEIGHT)) {
					i.update(weight);
				}
			}
			else {
				//Increments counter for packages delivered with overdrive by 1
				if (i.getName().contentEquals(NORMAL_TOTAL)) {
					i.update(1);
				}
				//Increments sum of package weights delivered normally by its weight
				else if (i.getName().contentEquals(NORMAL_WEIGHT)) {
					i.update(weight);
				}
			}
		}
	}
	
	public String toString() {
		return statistics.toString();
	}
	
}
