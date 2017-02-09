package nl.vu.cs.s2.simbadtest;


import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RobotFactory;

public class ExampleRobot extends Agent {

	private String currentMode;

    public ExampleRobot(Vector3d position, String name) {
        super(position, name);
        
        // Add bumpers
        RobotFactory.addBumperBeltSensor(this, 12);
        // Add sonars
        RobotFactory.addSonarBeltSensor(this, 4);        
    }

    /** This method is called by the simulator engine on reset. */
    public void initBehavior() {
        System.out.println("I exist and my name is " + this.name);
    }

    /** This method is call cyclically (20 times per second) by the simulator engine. */
    public void performBehavior() {
        
    	// perform the following actions every 5 virtual seconds
    	if(this.getCounter() % 5 == 0) {
	    	if(this.collisionDetected()) {
	    		this.currentMode = "avoidObstacle";
	    	} else {
	    		this.currentMode = "goAround";
	    	}
	        
	    	if(this.currentMode == "goAround") {
	    		// the robot's speed is always 0.5 m/s
	            this.setTranslationalVelocity(0.5);
	            
	    		// frequently change orientation
	            if ((getCounter() % 100) == 0) {
	                setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));
	            }    
	        } else {
	        	// don't move
	        	this.setTranslationalVelocity(0);
	        	// rotate only until obstacle is not there
	        	setRotationalVelocity(Math.PI / 2);
	        }
    	}
    	
    }
}