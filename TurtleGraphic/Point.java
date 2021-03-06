package TurtleGraphic;
import java.awt.Color;
import java.io.Serializable;

public class Point implements Serializable {
	int xCoor;
    int yCoor;
    Color color;
    private Boolean endPoint;
    public Point(int xCoor, int yCoor, Color color) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.color = color;
        endPoint = false;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setX(int xCoor) {
        this.xCoor = xCoor;
    }
    public int getXCoor() {
        return xCoor;
    }
    public void setY(int yCoor) {
        this.yCoor = yCoor;
    }
    public int getYCoor() {
        return yCoor;
    }
    public Boolean getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(Boolean endPoint) {
        this.endPoint = endPoint;
    }
}
