package automail;

public class Normal extends Mode {

	public Normal() {
		this.carryCapacity = 2;
		this.floorSpeed = 1;
	}
	
	@Override
	public int update(int currentFloor, int destFloor, boolean areWeOnTheRightFloor, Robot robot) {
		if(currentFloor < destFloor)
			return ++currentFloor;
		else
			return --currentFloor;
		
	}

}
