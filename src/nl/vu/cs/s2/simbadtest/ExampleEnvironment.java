package nl.vu.cs.s2.simbadtest;

import java.awt.Color;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Box;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class ExampleEnvironment extends EnvironmentDescription {
	public ExampleEnvironment() {
		
		// turn on the lights
        this.light1IsOn = true;
        this.light2IsOn = true;
        
        // enable the physics engine in order to have better physics effects on the objects
        this.setUsePhysics(true);
        
        // show the axes so that we know where things are
        this.showAxis(true);
        
        this.setWorldSize(20);
        
        Wall w1 = new Wall(new Vector3d(-5, 0, 0), 10, 2, this);
        w1.setColor(new Color3f(Color.BLUE));
        w1.rotate90(1);
        add(w1);
        
        Wall w2 = new Wall(new Vector3d(5, 0, 0), 10, 2, this);
        w2.setColor(new Color3f(Color.GREEN));
        w2.rotate90(1);
        add(w2);
        
        Wall w3 = new Wall(new Vector3d(0, 0, 5), 10, 2, this);
        w3.setColor(new Color3f(Color.RED));
        add(w3);
        
        Wall w4 = new Wall(new Vector3d(0, 0, -5), 10, 2, this);
        w4.setColor(new Color3f(Color.YELLOW));
        add(w4);
        
        Wall roomWall1 = new Wall(new Vector3d(2, 0, -3.5), 3, 1, this);
        roomWall1.setColor(new Color3f(Color.RED));
        roomWall1.rotate90(1);
        add(roomWall1);
        
        Wall roomWall2 = new Wall(new Vector3d(3.5, 0, -2), 3, 1, this);
        roomWall2.setColor(new Color3f(Color.YELLOW));
        add(roomWall2);
        
        Box box1 = new Box(new Vector3d(-3, 0, -3), new Vector3f(1, 1, 1), this);
        box1.setColor(new Color3f(Color.ORANGE));
        add(box1);
        
        Box box2 = new Box(new Vector3d(-3, 0, 3), new Vector3f(1, 1, 1), this);
        box2.setColor(new Color3f(Color.ORANGE));
        add(box2);
        
    }
}
