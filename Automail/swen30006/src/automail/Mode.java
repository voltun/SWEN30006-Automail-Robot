package automail;

public abstract class Mode {
	
	public int carryCapacity;
	int floorSpeed;

	
	public abstract int update(int currentFloor, int destFloor, boolean areWeOnTheRightFloor, Robot robot);
}
