package automail;

import automail.Robot.RobotState;

public class Overdrive extends Mode {
	
	int coolOffTime;
	int coolOffTimer = 0;
	
	public Overdrive(int carryCapacity, int floorSpeed, int coolOffTime) {
		this.carryCapacity = carryCapacity;
		this.floorSpeed = floorSpeed;
		this.coolOffTime = coolOffTime;
	}
	
	@Override
	public int update(int currentFloor, int destFloor, boolean areWeOnTheRightFloor, Robot robot) {
		
		if(coolOffTimer==0) {
			if(robot.current_state == RobotState.DELIVERING && robot.getHand() instanceof PriorityMailItem) {
				if(currentFloor<destFloor-floorSpeed) {
					currentFloor += floorSpeed;
				} else if(currentFloor > destFloor + floorSpeed) {
					currentFloor -= floorSpeed;
				} else {
					currentFloor = destFloor;
					coolOffTimer = coolOffTime;
				}
			} else {
				if(currentFloor < destFloor)
					currentFloor++;
				else if(currentFloor > destFloor)
					currentFloor--;
			}
		} else {
			coolOffTimer--;
		}
		
		return currentFloor;
	}
}
