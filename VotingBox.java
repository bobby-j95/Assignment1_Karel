import stanford.karel.*;
//Robert Johns Jr.
/*This program checks for "hanging chads" in voting ballots using Karel
 * If a ballot was not punched it will move to the next ballot
 * If the ballot was punched but still has some left it will clean up the rest of the column of the ballot
 * It will always check based off of the middle punch (empty then check the rest, otherwise move on)*/
public class VotingBox extends SuperKarel {

	public void run() {
		move();
		while(frontIsClear()) {
			if(noBeepersPresent()) {
				checkAbove();
			}else {
				movementChecker();
			}
		}
				
	}
	
	/*This method checks above for a beeper and changes Karel's direction to look below*/
	private void checkAbove() {
		turnLeft();
		move();
		while(beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		checkBelow();
	}
	
	/*This method checks below for a beeper and changes Karel's direction to face normally and walk forward*/
	private void checkBelow() {
		movementChecker();
		while(beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		turnRight();
		movementChecker();
	}
	
	/*This method is used in multiple ways
	 * 1) To allow Karel to go to the next hole punch set to start the checker
	 * 2) To allow Karel to go from the above checker to the bottom of the box
	 */
	private void movementChecker() {
		for(int x=0; x<2; x++) {
			if(frontIsClear()) {
				move();
			}
		}
	}
	
		
}
