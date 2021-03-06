package TurtleGraphic;
import java.awt.Color;
import java.util.*;
import java.util.List;
import tools.*;
public class Turtle extends Bean {
	public static Integer WORLD_SIZE = 250;
	Point location;
    List<Point> path;
    boolean penFlag;
    private Heading direction;

    public Turtle() {
        //init later....
        location = new Point(65, 65, Color.BLACK);
        path = new LinkedList<Point>();
        path.add(new Point(65, 65, Color.BLACK));
        penFlag = true;
    }
    public void setLocation(Point currentPoint) {
        location = currentPoint;
    }
    public Point getLocation() {
        return location;
    }
    public List<Point> getPath(){ 
    	return path;
    }
    public boolean getPenFlag() {
        return penFlag;
    }
    public void setPenFlag() {
        penFlag = !penFlag;
        if (!penFlag) {
        	location.setEndPoint(true);
        }
        else {
        	path.add(location);
        }
        firePropertyChange(null, null, null);
    }

    public Color getColor() {
        return location.getColor();
    }

    public void move(int steps) {
        Point tempPoint = null;
        if (direction == Heading.NORTH) {
            if (penFlag == true) {
            	if(location.getYCoor() - steps <= 0){
                    Point bound1 = new Point(location.getXCoor(), 0, location.getColor());
                    path.add(bound1);

                    //check outOfBound
                    Point checkA = new Point(location.getXCoor(), -1, Color.BLACK);
                    path.add(checkA);
                    Point checkB = new Point(location.getXCoor(), WORLD_SIZE+1, Color.BLACK);
                    path.add(checkB);

                    Point bound2 = new Point(location.getXCoor(), 250, location.getColor());
                    path.add(bound2);
                    tempPoint = new Point(location.getXCoor(), location.getYCoor() - steps + WORLD_SIZE, location.getColor());
                }
            	else {
            		tempPoint = new Point(location.getXCoor(), location.getYCoor() - steps, location.getColor());
            	}
                path.add(tempPoint);
                location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), tempPoint.getColor());
            } 
            else {
            	int newXCoor;
        		int newYCoor;
        		if (location.getYCoor() - steps < 0) {
        			newYCoor = location.getYCoor() - steps + WORLD_SIZE;
        		}
        		else newYCoor = location.getYCoor() - steps;
        		
        		newXCoor = location.getXCoor();
        		tempPoint = new Point(newXCoor, newYCoor, location.getColor());
        		location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), tempPoint.getColor());
        		location.setEndPoint(true);
            }
             
        }
        
        if (direction == Heading.SOUTH) {
            if (penFlag == true) {
            	if(location.getYCoor() + steps >= WORLD_SIZE){
                    Point bound1 = new Point(location.getXCoor(), WORLD_SIZE, location.getColor());
                    path.add(bound1);

                    //check outOfBound
                    Point checkA = new Point(location.getXCoor(), -1, Color.BLACK);
                    path.add(checkA);
                    Point checkB = new Point(location.getXCoor(), WORLD_SIZE+1, Color.BLACK);
                    path.add(checkB);

                    Point bound2 = new Point(location.getXCoor(), 0, location.getColor());
                    path.add(bound2);
                    tempPoint = new Point(location.getXCoor(), location.getYCoor() + steps - WORLD_SIZE, location.getColor());
                }
            	else {
            		tempPoint = new Point(location.getXCoor(), location.getYCoor() + steps, location.getColor());
            	}
            	path.add(tempPoint);
                location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), location.getColor());
            } 
            else {
            	int newXCoor;
        		int newYCoor;
        		if (location.getYCoor() + steps > WORLD_SIZE) {
        			newYCoor = location.getYCoor() + steps - WORLD_SIZE;
        		}
        		else newYCoor = location.getYCoor() + steps;
        		
        		newXCoor = location.getXCoor();
        		tempPoint = new Point(newXCoor, newYCoor, location.getColor());
        		location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), tempPoint.getColor());
        		location.setEndPoint(true);
            }
            
        }
        
            if (direction == Heading.EAST) {
                if (penFlag == true) {
                	if(location.getXCoor() + steps >= WORLD_SIZE){
                        Point bound1 = new Point(WORLD_SIZE, location.getYCoor(), location.getColor());
                        path.add(bound1);

                        //check outOfBound
                        Point checkA = new Point(-1, location.getYCoor(), Color.BLACK);
                        path.add(checkA);
                        Point checkB = new Point(WORLD_SIZE+1, location.getYCoor(), Color.BLACK);
                        path.add(checkB);

                        Point bound2 = new Point(0, location.getYCoor(), location.getColor());
                        path.add(bound2);
                        tempPoint = new Point(location.getXCoor() + steps -WORLD_SIZE, location.getYCoor(), location.getColor());
                    }
                	else {
                		tempPoint = new Point(location.getXCoor() + steps, location.getYCoor(), location.getColor());
                	}
                	path.add(tempPoint);
                    location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), location.getColor());
                } 
                else {
                	int newXCoor;
            		int newYCoor;
            		if (location.getXCoor() + steps > WORLD_SIZE) {
            			newXCoor = location.getXCoor() + steps - WORLD_SIZE;
            		}
            		else newXCoor = location.getXCoor() + steps;
            		
            		newYCoor = location.getYCoor();
            		tempPoint = new Point(newXCoor, newYCoor, location.getColor());
            		location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), tempPoint.getColor());
            		location.setEndPoint(true);
                } 
            }
            if (direction == Heading.WEST) {
            	if (penFlag == true) {
            		if (location.getXCoor() - steps <= 0){
                        Point bound1 = new Point(0, location.getYCoor(), location.getColor());
                        path.add(bound1);

                        //check outOfBound
                        Point checkA = new Point(-1, location.getYCoor(), Color.BLACK);
                        path.add(checkA);
                        Point checkB = new Point(WORLD_SIZE+1, location.getYCoor(), Color.BLACK);
                        path.add(checkB);

                        Point bound2 = new Point(WORLD_SIZE, location.getYCoor(), location.getColor());
                        path.add(bound2);
                        tempPoint = new Point( location.getXCoor() - steps + WORLD_SIZE, location.getYCoor(), location.getColor());
                    }else {
                        tempPoint = new Point(location.getXCoor() - steps, location.getYCoor(), location.getColor());
                    }
                    path.add(tempPoint);
                    location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), location.getColor());    
            	}
            	else {
            		int newXCoor;
            		int newYCoor;
            		if (location.getXCoor() - steps < 0) {
            			newXCoor = location.getXCoor() - steps + WORLD_SIZE;
            		}
            		else newXCoor = location.getXCoor() - steps;
            		
            		newYCoor = location.getYCoor();
            		tempPoint = new Point(newXCoor, newYCoor, location.getColor());
            		location = new Point(tempPoint.getXCoor(), tempPoint.getYCoor(), tempPoint.getColor());
            		location.setEndPoint(true);
            	}
            }
            firePropertyChange(null, null, null);
    }
    
    public void clearPath(){
        Point tempPoint = location;
        path.clear();
        path.add(tempPoint);
        firePropertyChange(null, null, null);
    }
    
    public void turn(Heading direction){ 
    	this.direction = direction; }
}
